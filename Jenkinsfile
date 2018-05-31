node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"
    
    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "cliente"
    registryHost = "http://10.51.33.59:5000/"
    imageName = "${appName}:${tag}"
    env.BUILDIMG=imageName
	
    stage "Test"
	echo 'Testing..'
	echo 'End Testing..'
 
 	stage('Gradle Build') {
	    if (isUnix()) {
	        sh './gradlew clean buildImage'
	    } else {
	        bat 'gradlew.bat clean build'
	    }
	}
	
    
    stage "Deploy"
     	echo 'Deploying...'
	sh "kubectl apply -f kubernetes/servicio-cliente-dep.yaml"
	sh "kubectl apply -f kubernetes/servicio-cliente-svc.yaml"
		echo 'End Deploying..'
}
