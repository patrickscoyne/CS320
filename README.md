# CS-320 System Test, Automation QA

**How can I ensure that my code, program, or software is functional and secure?**

To ensure my code is functional, I wrote JUnit tests for every requirement and ran them frequently to catch issues early. In the Contact, Task, and Appointment services, I used equivalence partitioning and boundary value analysis to test valid and invalid inputs (null, empty, too long, past dates), and assertThrows to verify exceptions are thrown correctly. Also, I made use of the Eclipse IDE's coverage tool to check line and branch coverage. For security, I made fields like IDs final and non-updatable, and validated all inputs at the earliest point (constructor/setters).

**How do I interpret user needs and incorporate them into a program?**

I interpret users' needs by breaking down the software requirements into clear, testable pieces. In the Contact, Task, and Appointment assignments, the customer wanted services that could add, delete, and update objects using unique IDs, along with strict rules for each field. I turned each of those rules into specific test conditions and wrote JUnit tests to prove the code actually enforces them.

**How do I approach designing software?**

I approach designing software by analyzing the software requirements first. I focus on one requirement at a time to keep things simple. For this project, I used validation in the constructors and setters so rules (null checks, length limits, future dates) are not overlooked. I used HashMap for fast lookups and kept classes small with single responsibilities. Furthermore, I wrote tests early to guide design and catch problems as they happened.
