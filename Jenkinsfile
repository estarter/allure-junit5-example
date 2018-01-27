pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                withMaven(maven: 'mvn', mavenSettingsConfig: '87c779d7-40b7-4942-bb3c-472d3555d9d6') {
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
