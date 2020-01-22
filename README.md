# quarkus-bug-report

Bug reported at: https://github.com/quarkusio/quarkus/issues/6695

Resolution time: 20h

Description:

Having jandex in the parent pom and a module running unit tests with surefire and integration tests with failsafe causes an ambiguous exception because jandex twice all the beans.

Fix:
Jandex should be excluded from the build if quarkus is already included.
