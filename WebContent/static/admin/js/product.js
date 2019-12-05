async function fetchGet(
    url,
    params = null,
    messErr = null,
) {
    try {
        let headers = {
            Accept: 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:8080/Fashion/getListProduct/api'
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
        const response = await fetch('http://localhost:8080/Fashion/getListProduct/api',
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
                var tdPrice = createNode('td');
                var tdCategory = createNode('td');
                var tdDelete = createNode('td');
                var tdEdit = createNode('td');
                var btnDelete = createNode('button');
                var btnEdit = createNode('button');
                //child.className = "product-image";
                tdId.innerHTML = `${user.id}`;
                tdName.innerHTML = `${user.name}`;
                tdPrice.innerHTML = `${user.price}`;
                tdCategory.innerHTML = `${user.category.id}`;
                btnDelete.innerHTML = "Delete";
                btnDelete.onclick = function(){
                    deleteObjectToServer(user.id).then(document.location.reload(true));
                };
                btnEdit.innerHTML = "Edit";
                btnEdit.onclick = function(){
                	location.replace("http://localhost:8080/Fashion/admin/product/edit?id="+idz)              	
                };
                
                append(tdEdit, btnEdit);
                append(tdDelete, btnDelete);
                append(child, tdId);
                append(child, tdName);
                append(child, tdPrice);
                append(child, tdCategory);
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
        var response = await fetch("http://localhost:8080/Fashion/getListProduct/api", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080/Fashion/getListProduct/api',
            },
            body: JSON.stringify(obj)
        });
        debugger;
        let responseJson = await response.json();
        return responseJson.result;
    } catch (error) {
        console.error(`Error is : ${error}`);
    }
}

async function updateObjectToServer(obj) {
    try {
        var response = await fetch(`http://localhost:8080/Fashion/getListProduct/api/${obj.id}`, {
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
        var response = await fetch(`http://localhost:8080/Fashion/getListProduct/api/${id}`, {
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

async function insertProduct() {
    var name = await document.getElementById("nameInput").value;
    var price = await document.getElementById("priceInput").value;    
    var idcategory = await document.getElementById("categoryInput").value;
    var obj = {
        name: name,
        price: price,
        category: {
        	id : idcategory,
        }
    }
    debugger;
    await insertObjectToServer(obj).then(
        refreshDataFromServer()
    )
}

async function updateProduct() {
	var id = await document.getElementById("idInput").value;
    var name = await document.getElementById("nameInput").value;
    var price = await document.getElementById("priceInput").value;    
    var idcategory = await document.getElementById("categoryInput").value;
    var obj = {
    	id:id,
        name: name,
        price: price,
        category: {
        	id : idcategory,
        }
    }
    updateObjectToServer(obj);
}
