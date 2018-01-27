pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                withMaven(maven: 'mvn') {
                    sh 'mvn -Dmaven.test.failure.ignore=true clean verify'
                }
            }
        }
        stage("Reports") {
            steps {
                allure results: [[path: 'target/allure-results']]
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}
