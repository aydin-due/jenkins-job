job('job-DSL-1') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      git('https://github.com/aydin-due/jenkins-job.git', 'main') { node ->
        node / gitConfigName('aydin-due')
        node / gitConfigEmail('a219201085@unison.mx')
      }
    }
  	parameters {
      stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el job booleano')
      choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      booleanParam('agente', false)
    }
    triggers {
      cron('H/7 * * * *')
      githubPush()
    }
  	steps {
      shell("jobscript.sh")
    }
    publishers {
      mailer('aydinbdsalman@gmail.com', true, true)
      slackNotifier {
        notifyAborted(true)
        notifyEveryFailure(true)
        notifyNotBuilt(false)
        notifyUnstable(false)
        notifyBackToNormal(true)
        notifySuccess(false)
        notifyRepeatedFailure(false)
        startNotification(false)
        includeTestSummary(false)
        includeCustomMessage(false)
        customMessage(null)
        sendAs(null)
        commitInfoChoice('NONE')
        teamDomain(null)
        authToken(null)
      }
    }
}
