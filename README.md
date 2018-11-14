# Todolist-Rest_Api

The rest api developed for the project Todoing, a simple todo app.

## Client Repository

Find the client repo here: [Todolist-React-Client](https://github.com/yasinakman/Todolist-React-Client)

## Installation

You need maven and installed on your system to run the project. Cd into the project directory and run the following command to start the application. Rest API will accept requests at port 8080.

```sh
mvn spring-boot:run
```

## Database

[H2 inmemory database](https://github.com/h2database/h2database) has been used in this project. That means the data will not persist on the disk. 

No additional installation required for the database.

## Sample response JSON

- Request to http://localhost:8080/getTodoListAll enpoint will generate following data.
```json
[
  {
    "listId": 1,
    "listName": "Jeys Tasks",
    "items": [
      {
        "itemId": 2,
        "list": 1,
        "itemName": "Develope the Todolist project.",
        "itemDesc": "",
        "status": true,
        "deadline": "03-11-2018",
        "createDate": "12-11-2018",
      },
      {
        "itemId": 3,
        "list": 1,
        "itemName": "Go swimming",
        "itemDesc": "",
        "status": false,
        "deadline": "23-05-2018",
        "createDate": "02-10-2018",
        "dependencies": [
          
        ]
      },
      {
        "itemId": 4,
        "list": 1,
        "itemName": "Go out to have some fun",
        "itemDesc": "after finishing other tasks",
        "status": false,
        "deadline": "23-05-2018",
        "createDate": "02-10-2018",
        ]
      }
    ]
  }
]
```

## Credits
Developed by [Yasin Talha AKMAN](https://github.com/yasinakman).

## License
This project is licensed under the GNU General Public License v3.0 (GPL 3.0) - see the [LICENSE](LICENSE) file for details
