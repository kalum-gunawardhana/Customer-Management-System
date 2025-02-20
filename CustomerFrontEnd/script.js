const apiBaseUrl = 'http://localhost:8080/customer';

document.getElementById('addForm').addEventListener('submit', function (e) {
    e.preventDefault();
    const customerName = document.getElementById('customerName').value;
    const customerAddress = document.getElementById('customerAddress').value;
    const customerSalary = document.getElementById('customerSalary').value;

    const newCustomer = {
        name: customerName,
        address: customerAddress,
        salary: parseFloat(customerSalary)
    };

    fetch(`${apiBaseUrl}/add`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newCustomer),
    })
    .then(response => response.json())
    .then(data => {
        alert('Customer added successfully!');
        loadAllCustomers();
    })
    .catch(error => console.error('Error adding customer:', error));
});


function loadAllCustomers() {
    fetch(`${apiBaseUrl}/getAll`)
    .then(response => response.json())
    .then(data => {

        const customerUl = document.getElementById('customerUl');
        customerUl.innerHTML = '';

        data.forEach(customer => {
            const li = document.createElement('li');
            li.textContent = `ID: ${customer.id}, Name: ${customer.name}, Address: ${customer.address}, Salary: $${customer.salary}`;
            customerUl.appendChild(li);
        });
    })
    .catch(error => console.error('Error loading customers:', error));
}


function searchCustomerByName() {
    const name = document.getElementById('searchName').value;
    fetch(`${apiBaseUrl}/searchbyname/${name}`)
    .then(response => response.json())
    .then(data => {
        const customerUl = document.getElementById('customerUl');
        customerUl.innerHTML = '';

        data.forEach(customer => {
            const li = document.createElement('li');
            li.textContent = `ID: ${customer.id}, Name: ${customer.name}, Address: ${customer.address}, Salary: $${customer.salary}`;
            customerUl.appendChild(li);
        });
    })
    .catch(error => console.error('Error searching customer:', error));
}

function updateCustomer() {
    const id = document.getElementById('updateId').value;
    const name = document.getElementById('updateName').value;
    const address = document.getElementById('updateAddress').value;
    const salary = document.getElementById('updateSalary').value;

    const updatedCustomer = {
        id,
        name,
        address,
        salary: parseFloat(salary)
    };

    fetch(`${apiBaseUrl}/update`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedCustomer),
    })
    .then(response => response.json())
    .then(data => {
        alert('Customer updated successfully!');
        loadAllCustomers();
    })
    .catch(error => console.error('Error updating customer:', error));
}

function deleteCustomer() {
    const id = document.getElementById('deleteId').value;
    fetch(`${apiBaseUrl}/delete/${id}`, {
        method: 'DELETE',
    })
    .then(response => response.json())
    .then(data => {
        alert('Customer deleted successfully!');
        loadAllCustomers();
    })
    .catch(error => console.error('Error deleting customer:', error));
}

loadAllCustomers();