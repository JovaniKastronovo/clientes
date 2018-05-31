#!groovy

pipeline {
  agent none
	

  stages {
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
	  
    stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t jovaniac/servicio-cliente:0.0.1-ci-cd build/libs/ .'
      }
    }
	  
    stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push jovaniac/servicio-cliente:0.0.1-ci-cd'
        }
      }
    }
  }
}
