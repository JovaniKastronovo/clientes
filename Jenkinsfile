node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"
    
    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "cliente"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"
    env.BUILDIMG=imageName
	
    stage "Test"
	echo 'Testing..'
	echo 'End Testing..'
 
 	stage "Gradle Build"
	    if (isUnix()) {
	        dir('sub-dir') {sh './gradlew clean buildImage'}
	    } else {
	        dir('sub-dir') {bat 'gradlew.bat clean build'}
	    }
	
    stage "Build"
        echo 'Building MicroService Cliente..'
        sh "docker build -t ${imageName} build/lib/"
	echo 'End Building..'
    
    stage "Push"
	echo 'Pushing in Registry'
        sh "docker push ${imageName}"
	echo 'End Pushing..'
	
    
    stage "Deploy"
     	echo 'Deploying...'
	sh "kubectl apply -f kubernetes/servicio-cliente-dep.yaml"
	sh "kubectl apply -f kubernetes/servicio-cliente-svc.yaml"
		echo 'End Deploying..'
}