[README.md](https://github.com/user-attachments/files/22125666/README.md)
# 🚦 Traffic Density Controller

This project is a **Java-based simulation of a density-based traffic control system**.  
It mimics how traffic signals can adapt to vehicle density using **IR sensor logic**.

---

## 📌 Project Overview
- Detects traffic density using **simulated IR sensors**.  
- Assigns **green light priority** to roads with more vehicles.  
- Supports multiple modes:  
  - **Basic switching**  
  - **Priority-based control**  
  - **Timer-based with override**  
  - **GUI simulation using Swing**  

---

## 🛠️ Technologies Used
- **Java** (core simulation + GUI).  
- **IR sensors (simulated in code)** for vehicle detection.  
- **LEDs (simulated in console/GUI)** for traffic lights.  

---

## 📂 Project Structure
```
traffic-density-controller/
└── java-code/
    ├── TrafficControlBasic.java
    ├── TrafficControlPriority.java
    ├── TrafficControlTimer.java
    └── TrafficControlGUI.java
```

---

## ▶️ How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/traffic-density-controller.git
   cd traffic-density-controller/java-code
   ```

2. Compile any version, e.g.:
   ```bash
   javac TrafficControlBasic.java
   java TrafficControlBasic
   ```

3. Run GUI version:
   ```bash
   javac TrafficControlGUI.java
   java TrafficControlGUI
   ```

---

## 📊 Sample Output (Console Version)
```
Traffic Light Status:
Road1: GREEN
Road2: RED
Road3: RED
Road4: RED
-----------------------------
```

-- 

---

## 📜 License
This project is open-source under the **MIT License**.
