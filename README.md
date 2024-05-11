# hrms-revamp-v1

## Introduction:
The Appraisal Portal is a Java Spring Boot application designed to digitize and streamline the employee performance appraisal process within the organization. This portal provides a centralized platform for employees to submit self-appraisals and for managers to review, evaluate, and provide feedback, facilitating a more efficient and transparent appraisal workflow.

## Features:

### 1. User Authentication:
- Secure login functionality for both employees and managers ensures data privacy and access control.

### 2. Digital Appraisal Form:
- Employees can conveniently access the digital appraisal form through the portal.
- The form encompasses comprehensive sections covering various aspects of performance evaluation, including achievements, challenges, goals, and self-assessment.

### 3. Manager Review:
- Submitted appraisal forms are instantly accessible to designated managers for review.
- Managers can thoroughly evaluate employee performance based on the provided self-assessment and additional performance metrics.

### 4. Rating Submission:
- Managers can provide ratings and constructive feedback on different performance parameters directly within the portal.
- The system ensures that ratings and feedback are securely recorded and associated with the respective employee.

### 5. HR Approval:
- After the manager submits their ratings and feedback, the appraisal form is automatically forwarded to the HR department for final approval.
- HR personnel can review the submitted evaluations and ensure consistency and fairness across the organization.

## Installation:

1. **Clone the Repository:**
   - Clone the repository from the provided GitHub link.

2. **Database Setup:**
   - Set up a MySQL database and configure the `application.properties` file with the database connection details.

3. **Build and Run:**
   - Ensure Java JDK and Maven are installed on your system.
   - Navigate to the project directory and execute the command: `mvn spring-boot:run`.

## Usage:

1. **Employee Workflow:**
   - Employees log in using their credentials and access the appraisal form from their dashboard.
   - They fill out the appraisal form thoroughly, providing honest self-assessment and relevant details.
   - After completing the form, employees submit it for manager review.

2. **Manager Workflow:**
   - Managers receive notifications or access to review submitted appraisal forms from their dashboard.
   - They carefully review the employee's self-appraisal, evaluate performance metrics, and provide ratings and feedback.
   - Once satisfied with the evaluation, managers submit the ratings, which are then forwarded to HR.

3. **HR Approval:**
   - HR personnel access the submitted appraisal forms and ensure the consistency and fairness of evaluations.
   - They can review ratings provided by managers and finalize the appraisal process.

## Acknowledgments:
We extend our gratitude to the Java Spring Boot community for their invaluable resources and support that contributed to the development of this project.
