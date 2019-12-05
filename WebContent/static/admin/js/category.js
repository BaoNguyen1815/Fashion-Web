async function fetchGet(
    url,
    params = null,
    messErr = null,
) {
    try {
        let headers = {
            Accept: 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:8080/Fashion/getListCategory/api'
        };
        // if (isAuthorization)
        //     headers.Authorization = await AsyncStorage.getItem('token');
        let requestInit = { method: 'GET', headers };
        let queryString = '';
        // if (params) {
        //     queryString = `?${Object.keys(params)
        //         .map(key => `${key}=${params[key] || ''}`)
        //         .join('&')}`;
        // }
        const response = await fetch('http://localhost:8080/Fashion/getListCategory/api',
            requestInit,
        );
        if (response.status === 403) throw Error('invalidToken');
        if (response.status === 200) return await response.json();
        if (messErr) throw Error(messErr);
    } catch (error) {
        throw error;
    }
};

function refreshDataFromServer() {
    const parent = document.getElementById('tbody');
    fetchGet(null, null, null)
        .then(users => {
            users.map((user) => {
            	var idz = `${user.id}`;
                var child = createNode('tr');
                var tdId = createNode('td');
                var tdName = createNode('td');
                var tdDescription = createNode('td');
                var tdDelete = createNode('td');
                var tdEdit = createNode('td');
                var btnDelete = createNode('button');
                var btnEdit = createNode('button');
                //child.className = "product-image";
                tdId.innerHTML = `${user.id}`;
                tdName.innerHTML = `${user.name}`;
                tdDescription.innerHTML = `${user.description}`;
                btnDelete.innerHTML = "Delete";
                
                btnDelete.onclick = function(){
                    deleteObjectToServer(user.id).then(document.location.reload(true));
                };
                
                btnEdit.innerHTML = "Edit";
                btnEdit.onclick = function(){
                	location.replace("http://localhost:8080/Fashion/admin/category/edit?id="+idz)              	
                };
                
                append(tdEdit, btnEdit);
                append(tdDelete, btnDelete);
                append(child, tdId);
                append(child, tdName);
                append(child, tdDescription);
                append(child, tdDelete);
                append(child, tdEdit);
                append(parent, child);
            })
            console.log(users);
        })
        .catch(error => {
            console.log(error)
        });
};


window.addEventListener('load', function () {
    refreshDataFromServer();
}, false);

function createNode(element) {
    return document.createElement(element);
}
function append(parent, el) {
    return parent.appendChild(el);
}

async function insertObjectToServer(obj) {
    try {
        var response = await fetch("http://localhost:8080/Fashion/getListCategory/api", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080/Fashion/getListCategory/api',
            },
            body: JSON.stringify(obj)
        });
        let responseJson = await response.json();
        return responseJson.result;
        
        //location.replace("http://localhost:8080/Fashion/admin/category/edit")
    } catch (error) {
        console.error(`Error is : ${error}`);
    }
    
}

async function updateObjectToServer(obj) {
    try {
        var response = await fetch(`http://localhost:8080/Fashion/getListCategory/api/${obj.id}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(obj)
        });
        let responseJson = await response.json();
        return responseJson.result;
    } catch (error) {
        console.error(`Error is : ${error}`);
    }
}
async function deleteObjectToServer(id) {
    try {
        var response = await fetch(`http://localhost:8080/Fashion/getListCategory/api/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
        });
        var responseJson = await response.json();
        return responseJson.result;
    } catch (error) {
        console.error(`Error is : `);
    }
}




/*function clearForm() {
    document.getElementById("usernameInput").value = "";
    document.getElementById("passwordInput").value = "";
}*/

async function insertCategory() {
    var name = await document.getElementById("nameInput").value;
    var description = await document.getElementById("descriptionInput").value;
    var obj = {
        name: name,
        description: description
    }
    await insertObjectToServer(obj).then(
        refreshDataFromServer()
    )
}

async function updateCategory() {
	var id = await document.getElementById("idInput").value;
	var name = await document.getElementById("nameInput").value;
	var description = await document.getElementById("descriptionInput").value;
	    var obj = {
	    	id:id,
	        name: name,
	        description: description
	    }
    updateObjectToServer(obj);
}
