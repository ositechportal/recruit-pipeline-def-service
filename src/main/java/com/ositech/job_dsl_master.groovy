job('Employee-Service-Job') {
    scm {
        git {
            remote {
                url 'https://github.com/ositechportal/employee-service.git'
            }
            extensions {
                wipeOutWorkspace()
            }
            branch '*/master'
        }
    }

    steps {
        gradle {
            tasks('clean')
            tasks('test')
            switches('-i')
            useWrapper()
        }
    }

    triggers {
        scm('* * * * *') {
            ignorePostCommitHooks()
        }
    }


    wrappers {
        colorizeOutput()
    }
}

job('Recruit-Service-Job') {
    scm {
        git {
            remote {
                url 'https://github.com/ositechportal/recruit-service.git'
            }
            extensions {
                wipeOutWorkspace()
            }
            branch '*/master'
        }
    }

    steps {
        gradle {
            tasks('clean')
            tasks('test')
            switches('-i')
            useWrapper()
        }
    }

    triggers {
        scm('* * * * *') {
            ignorePostCommitHooks()
        }
    }


    wrappers {
        colorizeOutput()
    }
}

listView('Branch Jobs') {
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
    jobs {
        name('Employee-Service-Job')
        name('Recruit-Service-Job')
    }
}