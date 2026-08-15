# SpringMVCSearch

Spring MVC Search application.

## CI/CD

This project uses Jenkins for CI/CD automation.

Pipeline flow:

GitHub → Jenkins → Maven → SonarQube → Gitleaks → Trivy → Docker → Kubernetes
