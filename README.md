# streamLINE
Group project for Agile Programming with Design Patterns

To submit changes:
-Download and install Git, using GitHub credentials
-Open Git Bash and navigate to directory where you want the project stored
-Type: $ git clone https://github.com/kbestul2/cvtc-agile-group-project.git
-If repository already exists on your computer, type: $ git pull
-Make changes to the project
-Type: $ git add .
-Type: $ git merge
-Resolve any merge conflicts by picking and choosing which code should be kept
-Type: $ git commit
-Type a short message summarizing your changes, then save and close the text editor
-Type: $ git push

*Note: NEVER do "$ git push -f" when push is not working.

To fix servlet-api.jar errors:
-Right click on the top-level project folder in the project explorer
-Click "properties"
-Go to "Java Build Path"
-Go to the "Libraries" tab
-Select "servlet-api.jar" and click the "Edit" button
-Navigate to the servlet-api.jar in your TomCat server installation (apache-tomcat-9.0.0.M26\lib)
-Click Apply

* Note: You may need to do something similar for the Maven Dependencies and the JRE System Library (jdk1.8.0_221)