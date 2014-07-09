package ua.vn.os.listeners

import org.gradle.api.execution.*
import org.gradle.api.*

class ReleaseVersionListener implements TaskExecutionGraphListener {
	final static String releaseTaskPath = ':release'
	
	@Override
	void graphPopulated(TaskExecutionGraph taskGraph) {

		if(taskGraph.hasTask(releaseTaskPath)) {
			List<Task> allTasks = taskGraph.allTasks
			Task releaseTask = allTasks.find {it.path == releaseTaskPath }
			Project project = releaseTask.project
			
			if(!project.version.release) {
				project.version.release = true
				project.ant.propertyfile(file: project.versionFile) {
					entry(key: 'release', type: 'string', operation: '=', value: 'true')
				}
			}
		}
	}
}