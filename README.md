## Problem Statement :
Problem Statement
Troop training simulation is inspired by Clash of Clans games. As a gaming programmer, you have to create a simulation software using which gamers can train army troops.

Army Troops
There are two kinds of troops: Archers and Barbarians. Each trooper (archer/barbarian) has the following characteristics:

| Troops    | Training Time | Training Cost | Weapon        |
|-----------|---------------|---------------|---------------|
| Barbarian | 3             | 10            | Sword         |
| Archer    | 6             | 20            | Bow and Arrow |

Barracks
Barracks are where each trooper gets trained. The following rules apply to barracks:

Only one trooper can be trained at a given point of time.
The maximum seat capacity of a barracks is 10.
Others have to wait outside the barracks.
Barracks can have a mix of troopers, e.g., 5 Archers and 5 Barbarians, or 4 Archers and 6 Barbarians, or 10 Archers, or 10 Barbarians.
Army Camp
The army camp is where troops assemble after training.

Scenario 1
Simulate the training and train barbarians and/or archers. As a gamer:

You should be able to input the number of barbarians and/or archers you would like to train.
You should be able to see how many troops are trained and available in the troop camp after training completes.# Troop Simulation Game

## Overview

This project implements a Troop Simulation Game using the MVC (Model-View-Controller) architecture. The game allows users to create, train, and manage troops within an army camp. It separates concerns into controllers, services, repositories, and domain models following the MVC pattern to enhance maintainability and scalability.

## Architecture

### Controller

#### TroopController
- return response for creation of troop(like Archer , Barbarian..etc)
- Uses `TroopService` for troop validation and creation.
- Provides methods for creating troops of various types.

#### BarrackController
- Manages troop creation and training within the barrack and return response
- Relies on `BarrackService` for troop operations.
- Provides functionality for bulk troop creation and training.

#### ArmyCampController
- Manages troops in the army camp and return response.
- Utilizes `ArmyCampService` for troop management.
- Offers methods to add trained troops to the camp and retrieve troop counts.

### Service

#### TroopService
- Validates troop data and creates troops.
- Utilizes `TroopRepository` for troop persistence.
- Implements business logic for troop creation.

#### BarrackService
- Manages troop operations in the barrack.
- Relies on `BarrackRepository` for troop persistence.
- Implements troop creation and training logic.

#### ArmyCampService
- Handles troop operations in the army camp.
- Uses `ArmyCampRepository` for troop persistence.
- Implements methods for troop management in the camp.

### Repository

#### TroopRepository
- Interface for storing individual troops.
- Defines methods for inserting and retrieving troops.

#### BarrackRepository
- Interface for managing troops in the barrack.
- Provides methods for troop insertion, retrieval, and training.

#### ArmyCampRepository
- Interface for managing troops in the army camp.
- Defines methods for saving troops, retrieving trained troops, and managing troop counts.

### Repostiory Implementations

#### InMemoryTroopRepository
- Implements `TroopRepository` for in-memory troop storage.
- Uses `InMemoryDatabase` for data storage.

#### InMemoryBarrackRepository
- Implements `BarrackRepository` for in-memory barrack troop storage.
- Relies on `InMemoryDatabase` for data storage.

#### InMemoryArmyCampRepository
- Implements `ArmyCampRepository` for in-memory army camp troop storage.
- Utilizes `InMemoryDatabase` for data storage.

#### FakeDatabase
- Implements `InMemoryDatabase` for storing data.

### Domain

#### Model
##### Entitity
- Archer
- Barbarian
- Trooper
#### Value Objects
- TroopType: enum

#### Domain Service
- Training

### Dependency Injection

#### TroopModule
- Module for dependency injection using Google Guice.

### Main Application File

#### Main
- Main application file to start the Troop Simulation Game.

## Usage

To use the Troop Simulation Game:

1. Ensure all dependencies are installed.
2. Start the application.
3. Use the provided controllers to create, train, and manage troops.

### Gradle Dependency

```gradle
testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
implementation 'com.google.inject:guice:7.0.0'

