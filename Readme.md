Run locally:

```bash
mvn -Dmaven.test.failure.ignore=true clean verify
mvn allure:serve
```

Use Jenkinsfile to run as a pipeline.