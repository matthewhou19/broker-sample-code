# Broker Sample Code

## Restful API Sample Code for a Client

## Quick Start

Follow these steps to quickly start the project:

1. Open a terminal and navigate to the project directory:

   ```
   cd demo2
   ```

2. Build the Docker image (ensure Docker is running):

   ```
   docker build -t demo-app .
   ```

3. Run the Docker container:

   ```
   docker run -p 8080:8080 demo-app
   ```

This will start the application and make it accessible on port 8080.

## Test with Postman (After start the application)

To test the endpoints using Postman, follow these steps:

1. Open Postman.
2. Import the JSON file located in the `testscreen` directory.
3. Use the imported collection to test the 4 types of endpoint queries.

This will allow you to quickly and easily test the functionality of your endpoints.

### Implemented Features

1. **URL Parameter Validation in CustomerService**
   - Ensures all URL parameters are valid.
2. **Form Information Validation via CustomRequest Class**
   - Validates additional form data.
3. **H2 Database for Simulating Production Database**
   - Uses H2 database to mimic a production environment.
   - Adds simulation data for testing purposes.
4. **Data Filtering from H2 Database**
   - Filters data retrieved from the H2 database.
5. **Data Submission via Endpoints**
   - Allows data to be submitted through defined endpoints.

### Features Pending Implementation

1. **Detailed Error Messages for Bad Requests**
   - Provide comprehensive error messages for invalid parameters.
2. **User Credential Validation**
   - Validate user credentials for authentication.
3. **Paginated Data Responses**
   - Implement pagination to reduce response times.
4. **Enhanced Data Filtering**
   - Filter returned data by additional criteria such as pickup date, etc.
