# Advanced Smart Appointment Booking System (Healthcare & Services)

A comprehensive, scalable, and secure appointment booking system built with Spring Boot microservices architecture, specifically designed for healthcare providers and service-based businesses.

## Project Overview

This system provides a robust solution for healthcare providers and service businesses to manage appointments, with features including:
- User authentication and authorization
- Smart appointment scheduling
- Real-time notifications
- Analytics and reporting
- Admin dashboard
- Healthcare-specific features (patient records, medical history)
- Service provider management
- Resource allocation

## Architecture

The system is built using a microservices architecture with the following components:

### Microservices
1. **User Service**: Handles user management and authentication
2. **Appointment Service**: Manages appointments and availability
3. **Notification Service**: Handles email and SMS notifications
4. **Analytics Service**: Processes and provides business insights
5. **Healthcare Service**: Manages patient records and medical history
6. **Resource Service**: Handles resource allocation and management

### Technology Stack

#### Backend
- Spring Boot 3.2.3
- Spring Security with JWT
- Spring Data JPA
- Spring Cloud (Eureka, Config)
- PostgreSQL
- Redis (Caching)
- Twilio (SMS)
- Mailgun (Email)

#### Frontend
- React/Angular
- Material-UI
- Redux/Context API
- Chart.js for analytics

## Getting Started

### Prerequisites
- Java 17
- Maven
- PostgreSQL
- Redis
- Node.js (for frontend)

### Installation

1. Clone the repository
```bash
git clone https://github.com/Elyes2024-2023/Advanced-Smart-Appointment-Booking-System.git
```

2. Set up the database
```bash
# Create PostgreSQL database
createdb appointment_booking
```

3. Configure application properties
```bash
# Copy example properties files
cp user-service/src/main/resources/application.yml.example user-service/src/main/resources/application.yml
# Repeat for other services
```

4. Build the project
```bash
mvn clean install
```

5. Run the services
```bash
# Start each service
java -jar user-service/target/user-service.jar
java -jar appointment-service/target/appointment-service.jar
# ... and so on
```

## Features

### User Management
- Registration and authentication
- Role-based access control
- Profile management
- Patient/Client records

### Appointment Management
- Smart slot detection
- Conflict resolution
- Booking and cancellation
- Calendar integration
- Resource allocation

### Healthcare Features
- Patient medical history
- Treatment tracking
- Prescription management
- Medical reports

### Notifications
- Email notifications
- SMS alerts
- Real-time updates
- Appointment reminders

### Analytics
- Booking trends
- User behavior analysis
- Performance metrics
- Healthcare analytics

## API Documentation

API documentation is available at `/swagger-ui.html` when running the services.

## Security

- JWT-based authentication
- Role-based access control
- Data encryption
- Secure password storage
- HIPAA compliance features

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**Elyes**
- All Rights Reserved to Elyes 2024-2025

## Acknowledgments

- Spring Boot Team
- All contributors and supporters
- Healthcare industry experts
- Service industry professionals 