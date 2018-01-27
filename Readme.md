# Info

Test project for tesing allure reporting integration with junit5 on jenkins.

Allure official docs: https://docs.qameta.io/allure/#_junit_5

## Run locally

```bash
mvn -Dmaven.test.failure.ignore=true clean verify
mvn allure:serve
```

## Run as jenkins maven job

Configure a jenkins maven jobs, see config.xml exported job description.

On run, there's an exception:

```
[allure-junit5-mvn] $ /var/jenkins_home/tools/ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation/allure/bin/allure generate "/var/jenkins_home/workspace/allure-junit5-mvn/target/allure-results" -o "/var/jenkins_home/workspace/allure-junit5-mvn/target/allure-results"
Exception in thread "main" ru.yandex.qatools.allure.data.ReportGenerationException: Could not find any allure results
    at ru.yandex.qatools.allure.data.AllureReportGenerator.generate(AllureReportGenerator.java:58)
    at ru.yandex.qatools.allure.data.AllureReportGenerator.generate(AllureReportGenerator.java:53)
    at ru.yandex.qatools.allure.AllureMain.main(AllureMain.java:48)
Command aborted due to exception {}.
org.apache.commons.exec.ExecuteException: Process exited with an error: 1 (Exit value: 1)
    at org.apache.commons.exec.DefaultExecutor.executeInternal(DefaultExecutor.java:404)
    at org.apache.commons.exec.DefaultExecutor.execute(DefaultExecutor.java:166)
    at org.apache.commons.exec.DefaultExecutor.execute(DefaultExecutor.java:153)
    at ru.yandex.qatools.allure.command.ReportGenerate.runUnsafe(ReportGenerate.java:48)
    at ru.yandex.qatools.allure.command.AbstractCommand.run(AbstractCommand.java:52)
    at ru.yandex.qatools.allure.CommandLine.main(CommandLine.java:46)
ERROR: Build step failed with exception
ru.yandex.qatools.allure.jenkins.exception.AllurePluginException: Can not generate Allure Report, exit code: 1
    at ru.yandex.qatools.allure.jenkins.AllureReportPublisher.generateReport(AllureReportPublisher.java:296)
    at ru.yandex.qatools.allure.jenkins.AllureReportPublisher.perform(AllureReportPublisher.java:218)
    at hudson.tasks.BuildStepCompatibilityLayer.perform(BuildStepCompatibilityLayer.java:81)
    at hudson.tasks.BuildStepMonitor$1.perform(BuildStepMonitor.java:20)
    at hudson.model.AbstractBuild$AbstractBuildExecution.perform(AbstractBuild.java:744)
    at hudson.model.AbstractBuild$AbstractBuildExecution.performAllBuildSteps(AbstractBuild.java:690)
    at hudson.maven.MavenModuleSetBuild$MavenModuleSetBuildExecution.post2(MavenModuleSetBuild.java:1073)
    at hudson.model.AbstractBuild$AbstractBuildExecution.post(AbstractBuild.java:635)
    at hudson.model.Run.execute(Run.java:1749)
    at hudson.maven.MavenModuleSetBuild.run(MavenModuleSetBuild.java:543)
    at hudson.model.ResourceController.execute(ResourceController.java:97)
    at hudson.model.Executor.run(Executor.java:421)
```

## Run as jenkins pipeline job

Use Jenkinsfile to run as a pipeline.

On run, there's an exception:

```
[allure-junit5] $ /var/jenkins_home/tools/ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation/allure/bin/allure generate "/var/jenkins_home/workspace/allure-junit5/target/allure-results" -o "/var/jenkins_home/workspace/allure-junit5/allure-report"
Exception in thread "main" ru.yandex.qatools.allure.data.ReportGenerationException: Could not find any allure results
    at ru.yandex.qatools.allure.data.AllureReportGenerator.generate(AllureReportGenerator.java:58)
    at ru.yandex.qatools.allure.data.AllureReportGenerator.generate(AllureReportGenerator.java:53)
    at ru.yandex.qatools.allure.AllureMain.main(AllureMain.java:48)
Command aborted due to exception {}.
org.apache.commons.exec.ExecuteException: Process exited with an error: 1 (Exit value: 1)
    at org.apache.commons.exec.DefaultExecutor.executeInternal(DefaultExecutor.java:404)
    at org.apache.commons.exec.DefaultExecutor.execute(DefaultExecutor.java:166)
    at org.apache.commons.exec.DefaultExecutor.execute(DefaultExecutor.java:153)
    at ru.yandex.qatools.allure.command.ReportGenerate.runUnsafe(ReportGenerate.java:48)
    at ru.yandex.qatools.allure.command.AbstractCommand.run(AbstractCommand.java:52)
    at ru.yandex.qatools.allure.CommandLine.main(CommandLine.java:46)
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Declarative: Post Actions)
[Pipeline] deleteDir
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
[BFA] Scanning build for known causes...
[BFA] No failure causes found
[BFA] Done. 0s
ru.yandex.qatools.allure.jenkins.exception.AllurePluginException: Can not generate Allure Report, exit code: 1
    at ru.yandex.qatools.allure.jenkins.AllureReportPublisher.generateReport(AllureReportPublisher.java:296)
    at ru.yandex.qatools.allure.jenkins.AllureReportPublisher.perform(AllureReportPublisher.java:218)
    at org.jenkinsci.plugins.workflow.steps.CoreStep$Execution.run(CoreStep.java:80)
    at org.jenkinsci.plugins.workflow.steps.CoreStep$Execution.run(CoreStep.java:67)
    at org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution$1$1.call(SynchronousNonBlockingStepExecution.java:49)
    at hudson.security.ACL.impersonate(ACL.java:260)
    at org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution$1.run(SynchronousNonBlockingStepExecution.java:46)
    at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
    at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    at java.lang.Thread.run(Thread.java:745)
Finished: FAILURE
```
