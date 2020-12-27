# Spring with postgres and GraphQL

A simple project with a couple of basic entities to demonstrate the use and power of GraphQL use alongside postgresql.

This project has Voyager implemented to visualize the query schemas, after running the project, 
go to localhost:8080/Voyager.html

A few Example queries:

### Get all warehouses with nested products
```
{"query": "query { warehouses{aisle, products{name, price}}}"}
```
result:
```
{
    "data": {
        "warehouses": [
            {
                "aisle": "food",
                "products": [
                    {
                        "name": "kitkat",
                        "price": 0.5
                    },
                    {
                        "name": "snickers",
                        "price": 0.7
                    },
                    {
                        "name": "ham",
                        "price": 1.7
                    }
                ]
            },
            {
                "aisle": "toys",
                "products": [
                    {
                        "name": "gocart",
                        "price": 100.0
                    }
                ]
            }
        ]
    }
}
```

example 2:
Search by id
```
{"query": "query { warehouseById(id: 1){aisle, products{name, price}}}"}
```

result: 
```
{
    "data": {
        "warehouseById": {
            "aisle": "food",
            "products": [
                {
                    "name": "kitkat",
                    "price": 0.5
                },
                {
                    "name": "snickers",
                    "price": 0.7
                },
                {
                    "name": "ham",
                    "price": 1.7
                }
            ]
        }
    }
}
```

example 3:
With where clause
```
{"query": "query { warehouses(where: {aisle: {eq: \"food\"}}){aisle, products{name, price}}}"}
```

result: 
```
{
    "data": {
        "warehouses": [
            {
                "aisle": "food",
                "products": [
                    {
                        "name": "kitkat",
                        "price": 0.5
                    },
                    {
                        "name": "snickers",
                        "price": 0.7
                    },
                    {
                        "name": "ham",
                        "price": 1.7
                    }
                ]
            }
        ]
    }
}
```

### Agregate functions
example 1:
```
{"query": "query { products{avgOfPrice}}"}
```
```
{
    "data": {
        "products": [
            {
                "avgOfPrice": 25.725000008940697
            }
        ]
    }
}
```

example 2:
```
{"query": "query { warehouses{aisle, products{countOfPrice}}}"}
```
```
{
    "data": {
        "warehouses": [
            {
                "aisle": "food",
                "products": [
                    {
                        "countOfPrice": 3
                    }
                ]
            },
            {
                "aisle": "toys",
                "products": [
                    {
                        "countOfPrice": 1
                    }
                ]
            }
        ]
    }
}
```
