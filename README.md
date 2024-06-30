# Spring Modulith Project: Item, Inventory, and Order

## Introduction

This project is built using Spring Modulith, a framework designed to help developers build modular Spring applications. The goal of Spring Modulith is to promote a clean architecture, better separation of concerns, and enhanced maintainability by modularizing the application into distinct units.

## Goals of Spring Modulith

- **Modularization:** Break down a large monolithic application into smaller, manageable modules.
- **Encapsulation:** Ensure that each module encapsulates its own data and behavior, exposing only what is necessary to other modules.
- **Decoupling:** Reduce tight coupling between modules by using events for communication.
- **Maintainability:** Enhance the maintainability and readability of the codebase by organizing it into logical modules.

## Project Overview

This project consists of three primary modules: `Item`, `Inventory`, and `Order`. Each module handles a specific part of the business logic and communicates with other modules through Spring Modulith's event-driven mechanism.

### Item Module

The `Item` module is responsible for managing the items. It includes classes and services for item representation, creation, and management.

### Inventory Module

The `Inventory` module manages the stock of items. It handles the addition, removal, and tracking of items in the inventory.

### Order Module

The `Order` module processes customer orders. It coordinates with the `Item` and `Inventory` modules to ensure that orders are fulfilled correctly and efficiently.

## Non-Public Classes and Event Handling

In this project, classes are not public by default. This is a best practice in Java to limit the visibility of classes to their respective modules, promoting encapsulation and modularity. In Java, if a class is not explicitly marked as `public`, it has package-private visibility by default, meaning it is only accessible within its own package.

### Important Note: Default Scope in Java

In Java, the default scope for classes, methods, and fields is package-private, not public. This means that if you don't specify a visibility modifier (like `public` or `private`), the class, method, or field is only accessible within its own package. To maintain good encapsulation and modularity, avoid using `public` for everything. Only expose what is necessary to other modules or packages.

### Using `ApplicationEventPublisher`

To facilitate communication between modules, we use Spring's `ApplicationEventPublisher`. This allows us to publish and listen to events without making classes public. By using events, modules can interact with each other in a loosely coupled manner, enhancing the modularity and maintainability of the application.

## Project Structure

The project is organized into distinct modules, each with its own package. This modular structure helps in maintaining a clean and organized codebase.

