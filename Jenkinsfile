node {
	env.DOCKER_API_VERSION="1.23"
	sh "git rev-parse --short HEAD > commit-id"
	tag = readFile('commit-id').replace("\n", "").replace("\r", "")
	appName = "hello-kenzan-pipe"
	registryHost = "127.0.0.1:30400/"
	imageName = "${registryHost}${appName}:${tag}"
	env.BUILDIMG=imageName
  
	stage('Descargando Codigo') {
	 checkout scm
	}
	
	stage('Gradle Build') {
      	   if (isUnix()) {
            sh './gradlew clean buildImage'
      	  } else {
            bat 'gradlew.bat clean build'
      	}
  }
}
