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
        stage('Publish') {
            steps {
                echo 'Publish Allure report'
                allure results: [[path: 'target/allure-results']]
            }
        }
    }
}
