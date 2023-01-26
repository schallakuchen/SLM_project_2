# SLM_project_2
slm project reexamination opening hours.
Das Front-End aktualisiert sich bei Änderung dynamisch, sodass die Seite nicht neugeladen werden muss.
Man kann die Öffnungszeiten für jeden Tag eigen setzten. Die Öffnungszeiten abfragen. Die Zeiten auf Standartwerte zurücksetzen und einen Tag schließen.
Als Backend wurde eine Spring Web App verwendet und als Frontend eine Angular Application.


## How to use:
1. Den Source Code und das Jar File vom letzten Release herunterladen.
![image](https://user-images.githubusercontent.com/39189271/214960202-8aeb5d6b-7b9c-403d-aadf-6f73826bd246.png)
![image](https://user-images.githubusercontent.com/39189271/214960277-dab38ad8-e5df-478d-ac7c-28ca5cb3f38d.png)


2. Mit Java 19 die Jar Datei vom Backend mit diesem Befehl starten (Vorher die Pfade anpassen)
java -jar .\target\SLM_project_2-0.0.1-SNAPSHOT.jar at.technikum.slm_project_2.SlmProject2Application

![image](https://user-images.githubusercontent.com/39189271/214960953-e85b649a-c3b4-497d-b399-0babb34a2652.png)

3. Anschließend im Source-Code Ordner in den Frontend Ordner navigieren und ein CMD-Fenster öffnen und mit diesen Befehlen starten:
npm i
npm start

![image](https://user-images.githubusercontent.com/39189271/214961167-4bb9fed2-245a-48e7-b0fc-03402f9b97bf.png)


5. Das Frontend im Browser öffnen unter http://localhost:4200

![image](https://user-images.githubusercontent.com/39189271/214961356-9eca2182-dd03-40bd-aea1-f4b977eaf84a.png)


6. REST API Calls an localhost:8080 senden. In dem Fall mit einem Browser Plugin für Google Chrome

![image](https://user-images.githubusercontent.com/39189271/214961490-92e1d4e4-4c92-46d8-98b6-e64182a26238.png)


## Workflow
Zuerst wurde ein Github Repository und ein zugehöriges Projetk in form eines Kanbans verlinkt.
Anschließend wurden die ersten User Stories hinzugefügt und zu Tasks konvertiert, um sie durch später Commits mit Verlinkung abschließen zu können.
![SLM_Project_2_Kanban_Start](https://user-images.githubusercontent.com/39189271/214963147-e211b52d-7939-4e05-80a8-12f6b594f49f.png)

Es wurden die einzelnen Tasks dementsprechend zwischen den Kategorien ToDo, In Progress und Done verschoben.

![2023-01-25_21h21_20](https://user-images.githubusercontent.com/39189271/214963314-b82dc044-b1ae-4c75-aeb8-6bd36b0a7931.png)
![2023-01-25_21h25_53](https://user-images.githubusercontent.com/39189271/214963334-9e96b9e3-3824-436f-b8c6-f0275eb7eeab.png)
![2023-01-25_22h58_07](https://user-images.githubusercontent.com/39189271/214963338-68779ed0-384b-4624-98d9-725a4c64bbc0.png)


Bis letztlich alle Tasks abgeschlossen waren.
![image](https://user-images.githubusercontent.com/39189271/214963481-9188bfc1-19cf-4b6e-b233-856c6c40ebc0.png)


Während der Entwicklung wurde auf die Git Integration im IntelliJ zurückgegrifen und für die Features eigene Branches erstellt, die nach Abschluss in den Main Brunch gemerged wurden.
![image](https://user-images.githubusercontent.com/39189271/214963792-74cab74f-a82f-446d-b502-ad1f912c10e7.png)


Beim Anlegen des Projekts in IntelliJ haben wir direkt den eingebauten Spring Boot Initializer verwendet. Alles basiert auf JDK v19
Das Programm und deren Tests ist in einzelnen Java Class Files unterteilt. Das FrontEnd befindet sich als eigenständiges Projekt im Root Ordner
![image](https://user-images.githubusercontent.com/39189271/214964852-15c007e0-50b2-4324-851d-b60fbab2adb9.png)


Nachdem die Tests alle im Verbund erfolgreich abgeschlossen haben wurde ein letzer Step in Github festgeschrieben.
Zudem wurde in Github Actions eine Pipeline eingerichtet -> Siehe Github Repo
![image](https://user-images.githubusercontent.com/39189271/214965294-ab746157-f635-4008-b281-b32cd50c668e.png)


Anschließend wurde noch vom Maven Deploy das JAR-File vom Backend generiert und als Release 1.0.0 in Github veröffentlicht.


