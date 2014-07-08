package ua.vn.os.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile

class ReleaseVersionTask extends DefaultTask {
	@Input Boolean release
	@OutputFile File destFile
	
	ReleaseVersionTask() {
		group = 'versioning'
		description = 'Makes project a release version.'
	}

	@TaskAction
	void start() {
		project.version.release = true
		ant.propertyfile(file: destFile) {
			entry(key: 'release', type: 'string', operation: '=', value: 'true')
		}
	}
}