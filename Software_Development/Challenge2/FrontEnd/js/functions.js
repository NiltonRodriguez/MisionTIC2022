// Select the table url
function selectTable(tableName){
    tableUrl = "";
    if (tableName == "skate") {
        tableUrl = "https://g01a4032abb75f1-skatedb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/skate/skate";
    }
    else if(tableName == "client") {
        tableUrl = "https://g01a4032abb75f1-skatedb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client";
    }
    else if(tableName == "message"){
        tableUrl = "https://g01a4032abb75f1-skatedb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message";
    }
    return tableUrl;
}

// Select the info acording to the table.
function selectActualInfo(tableName){
    actualInfo = {};
    if (tableName == "skate") {
        actualInfo = {
            id: $("#id").val(),
            brand: $("#brand").val(),
            model: $("#model").val(),
            category_id: $("#category_id").val(),
            name: $("#name").val()
        };
    }
    else if(tableName == "client") {
        actualInfo = {
            id: $("#id2").val(),
            name: $("#name2").val(),
            email: $("#email").val(),
            age: $("#age").val()
        };
    }
    else if(tableName == "message"){
        actualInfo = {
            id: $("#id3").val(),
            messagetext: $("#messagetext").val()
        };
    }
    return actualInfo;
}

// Clear fields acording to the table.
function clearFields(tableName){
    if (tableName == "skate") {
        $("#id").val("");
        $("#brand").val("");
        $("#model").val("");
        $("#category_id").val("");
        $("#name").val("");
    }
    else if(tableName == "client") {
        $("#id2").val("");
        $("#name2").val("");
        $("#email").val("");
        $("#age").val("");
    }
    else if(tableName == "message"){
        $("#id3").val("");
        $("#messagetext").val("");
    }
}

// Make an HTTP GET request.
function getInfo(tableName){
    $.ajax({
        url: selectTable(tableName),
        type: "GET",
        dataType: "JSON",
        success: function(answer){
            console.log(answer);
            displayAnswer(tableName, answer.items);
            clearFields(tableName);
        }
    })
}

// Function to display the GET results.
function displayAnswer(tableName, items){
    $("#result").empty();
    let newTable = "<table>";
    if (tableName == "skate"){
        newTable += "<tr>";
        newTable += "<th>ID</th>";
        newTable += "<th>MARCA</th>";
        newTable += "<th>MODELO</th>";
        newTable += "<th>ID DE LA CATEGORIA</th>";
        newTable += "<th>NOMBRE</th>";
        newTable += "</tr>";
    }
    else if (tableName == "client"){
        newTable += "<tr>";
        newTable += "<th>ID</th>";
        newTable += "<th>NOMBRE</th>";
        newTable += "<th>EMAIL</th>";
        newTable += "<th>EDAD</th>";
        newTable += "</tr>";
    }
    else if (tableName == "message"){
        newTable += "<tr>";
        newTable += "<th>ID</th>";
        newTable += "<th>MENSAJE</th>";
        newTable += "</tr>";
    }
    for(i = 0; i < items.length; ++i){
        if (tableName == "skate"){
            newTable += "<tr>";
            newTable += "<td>" + items[i].id + "</td>";
            newTable += "<td>" + items[i].name + "</td>";
            newTable += "<td>" + items[i].brand + "</td>";
            newTable += "<td>" + items[i].model + "</td>";
            newTable += "<td>" + items[i].category_id + "</td>";
            // Delete button.
            newTable += "<td> <button onclick='deleteInfo(" + '"' + tableName + '", ' + items[i].id + ")'>Eliminar</button>";
            newTable += "</tr>";
        }
        else if (tableName == "client"){
            newTable += "<tr>";
            newTable += "<td>" + items[i].id + "</td>";
            newTable += "<td>" + items[i].name + "</td>";
            newTable += "<td>" + items[i].email + "</td>";
            newTable += "<td>" + items[i].age + "</td>";
            // Delete button.
            newTable += "<td> <button onclick='deleteInfo(" + '"' + tableName + '", ' + items[i].id + ")'>Eliminar</button>";
            newTable += "</tr>";
        }
        else if (tableName == "message"){
            newTable += "<tr>";
            newTable += "<td>" + items[i].id + "</td>";
            newTable += "<td>" + items[i].messagetext + "</td>";
            // Delete button.
            newTable += "<td> <button onclick='deleteInfo(" + '"' + tableName + '", ' + items[i].id + ")'>Eliminar</button>";
        }
    }
    newTable += "</table>";
    $("#result").append(newTable);
}

// Function to save new information with a POST request.
function saveInfo(tableName){
    let actualData = selectActualInfo(tableName);
    let dataToSend = JSON.stringify(actualData);
    $.ajax({
        url: selectTable(tableName),
        type: "POST",
        data: actualData,
        dataType: "JSON",
        success: function(answer){
            $("#result").empty();
            alert("¡Guardado con éxito!")
        }
    })
}

// Function to update a table info with a PUT request.
function updateInfo(tableName){
    let actualData = selectActualInfo(tableName);
    let dataToSend = JSON.stringify(actualData);
    $.ajax({
        url: selectTable(tableName),
        type: "PUT",
        data: dataToSend,
        contentType: "application/JSON",
        dataType: "JSON",
        success: function(answer){
            $("#result").empty();
            alert("¡Actualizado con éxito!")
        }
    })
}

// Function to delete an element of a table with a DELETE request.
function deleteInfo(tableName, register_id){
    let register = {
        id: register_id
    };
    let dataToSend = JSON.stringify(register);
    $.ajax({
        url: selectTable(tableName),
        type: "DELETE",
        data: dataToSend,
        contentType: "application/JSON",
        dataType: "JSON",
        success: function(answer){
            $("#result").empty();
            alert("¡El registro se ha eliminado!")
        }
    })
}
