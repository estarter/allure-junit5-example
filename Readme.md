# Info

Test project for tesing allure reporting integration with junit5 on jenkins.

Allure official docs: https://docs.qameta.io/allure/#_junit_5

Allure chat: https://gitter.im/allure-framework/allure-core

## Run locally

```bash
mvn -Dmaven.test.failure.ignore=true clean verify
mvn allure:serve
```

## Run as jenkins maven job

Configure a jenkins maven jobs, see config.xml exported job description.

## Run as jenkins pipeline job

Use Jenkinsfile to run as a pipeline.

## History

Associated issue: https://github.com/jenkinsci/allure-plugin/issues/196
The issue was fixed with update of allure plugin in jenkins (Global tools configuration -> Allure Commandline)
