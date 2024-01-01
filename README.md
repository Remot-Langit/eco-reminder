# eco-reminder - SDG No. 3 Climate Action.

Members of Group:
- Astuti Solihatunnisa
- Fairuz Zulia Muntaha
- Mohamad Fikri
- Muhammad Hikmat Mustofa
- Sri Rahayu

## ERD
![ERD Picture](https://raw.githubusercontent.com/Remot-Langit/eco-reminder/main/erd.png)
## Class Diagram
![Class Diagram Picture](https://raw.githubusercontent.com/Remot-Langit/eco-reminder/main/class-diagram.svg)

## How To Run
You can open this project from netbeans or intellij. Make sure the jdk in your computer is >= 17.x.x
- clone this project
  ```sh
  git clone https://github.com/Remot-Langit/eco-reminder.git
  ```
- rename .env.example to .env (edit whatever if you want)
- open in your favorite IDE (Apache Netbeans or Intellij Idea or maybe VSCode also work)
- run the project

## Alternative Run
If your laptop is a potato, maybe you can use this method. 
- Download the [latest release](https://github.com/Remot-Langit/eco-reminder/releases/download/release/eco-reminder-1.0.0.zip).
- After downloading, extract it to any folder.
- Right-click on the folder that extract and open in terminal.
- Download the javafx library, then extract the javafx to any folder.
- Copy the extracted javafx path.
- Run this code in the terminal that was opened
  ```sh
  java -jar --module-path <The path javafx>/lib --add-modules=javafx.fxml,javafx.controls ./eco-reminder.jar
  ```
