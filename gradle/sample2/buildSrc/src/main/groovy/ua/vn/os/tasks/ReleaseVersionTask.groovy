package ua.vn.os.tasks

import org.gradleApi.*

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