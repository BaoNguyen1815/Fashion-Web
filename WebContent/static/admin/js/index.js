async function fetchGet(
    url,
    params = null,
    messErr = null,
) {
    try {
        let headers = {
            Accept: 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:8080/Fashion/getListUser/api'
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
        const response = await fetch('http://localhost:8080/Fashion/getListUser/api',
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
                var child = createNode('tr');
                var tdId = createNode('td');
                var tdName = createNode('td');
                var tdUsername = createNode('td');
                var tdPass = createNode('td');
                var tdAvatar = createNode('td');
                var tdDelete = createNode('td');
                var btnDelete = createNode('button');
                //child.className = "product-image";
                tdId.innerHTML = `${user.id}`;
                tdName.innerHTML = `${user.name}`;
                tdUsername.innerHTML = `${user.username}`;
                tdPass.innerHTML = `${user.password}`;
                tdAvatar.innerHTML = `${user.avatar}`;
                append(tdDelete, btnDelete);
                append(child, tdId);
                append(child, tdName);
                append(child, tdUsername);
                append(child, tdPass);
                append(child, tdAvatar);
                append(child, tdDelete);
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
        let response = await fetch("http://localhost:8080/Fashion/getListUser/api", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080/Fashion/getListUser/api',
            },
            body: JSON.stringify(obj)
        });
        let responseJson = await response.json();
        return responseJson.result;
    } catch (error) {
        console.error(`Error is : ${error}`);
    }
}

async function updateObjectToServer(obj) {
    try {
        let response = await fetch(`http://localhost:8080/Fashion/getListUser/api/${obj.id}`, {
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
        let response = await fetch(`http://localhost:8080/Fashion/getListUser/api/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ id })
        });
        let responseJson = await response.json();
        return responseJson.result;
    } catch (error) {
        console.error(`Error is : `);
    }
}

function clearForm() {
    document.getElementById("nameInput").value = "";
    document.getElementById("usernameInput").value = "";
    document.getElementById("passwordInput").value = "";
}

async function insertUser() {
    var name = await document.getElementById("nameInput").value;
    var username = await document.getElementById("usernameInput").value;
    var password = await document.getElementById("passwordInput").value;
    var obj = {
        name: name,
        username: username,
        password: password
    }
    debugger;
    await insertObjectToServer(obj).then(
        refreshDataFromServer()
    )
    
}

function updateUser() {
    const obj = {
        name: 'IP31dâda313',
        price: '34123',
        status: true
    }
    updateObjectToServer(obj);
}

function deleteUser() {
    deleteObjectToServer(18);
}