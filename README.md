## Features

### Category
- Get all categories
- Create new category
- Update category
- Change category status (true/false)
- Delete category

### Product
- Get all products
- Create new product
- Update product
- Change product status (true/false)
- Delete product

 ### API Endpoints
Category API
Method	Endpoint	Description
GET	/api/categories	Get all categories
POST	/api/categories	Create new category
PUT	/api/categories/{id}	Update category by id
PATCH	/api/categories/{id}/status?status=true	Change status (true/false)
DELETE	/api/categories/{id}	Delete category by id
Example request (POST - Create Category)
{
  "categoryName": "Drink",
  "categoryStatus": true
}

##########

Product API
Method	Endpoint	Description
GET	/api/products	Get all products
POST	/api/products	Create new product
PUT	/api/products/{id}	Update product by id
PATCH	/api/products/{id}/status?status=false	Change status (true/false)
DELETE	/api/products/{id}	Delete product by id
Example request (POST - Create Product)
{
  "productName": "Coca Cola",
  "productPrice": 12000,
  "productStock": 100,
  "productStatus": true,
  "category": {
    "id": 1
  }
}
