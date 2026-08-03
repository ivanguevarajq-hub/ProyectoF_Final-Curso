-- 1. Crear la base de datos y usarla
CREATE DATABASE IF NOT EXISTS bd_Clinica;
USE bd_Clinica;

-- 2. Tabla Usuarios (HU-01, HU-02)
CREATE TABLE Usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    nombreUsuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

-- 3. Tabla Pacientes (HU-05)
CREATE TABLE Pacientes (
    dni VARCHAR(8) PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    sexo CHAR(1) NOT NULL,
    telefono VARCHAR(9) NOT NULL,
    direccion VARCHAR(200),
    apoderado VARCHAR(150),
    numeroHistoriaClinica VARCHAR(200) UNIQUE,
    estado VARCHAR(20) DEFAULT 'ACTIVO'
);

-- 4. Tabla Medicos (HU-10)
CREATE TABLE Medicos (
    numeroColegiatura VARCHAR(10) PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    sexo CHAR(1) NOT NULL,
    telefono VARCHAR(9),
    direccion VARCHAR(200),
    especialidad VARCHAR(100) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

-- 5. Tabla Citas (HU-13)
CREATE TABLE Citas (
    idCita INT AUTO_INCREMENT PRIMARY KEY,
    dni_paciente VARCHAR(8) NOT NULL,
    colegiatura_medico VARCHAR(10) NOT NULL,
    fecha DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    estado VARCHAR(20) DEFAULT 'PROGRAMADA',
    FOREIGN KEY (dni_paciente) REFERENCES Pacientes(dni),
    FOREIGN KEY (colegiatura_medico) REFERENCES Medicos(numeroColegiatura)
);

-- 6. Tabla Atenciones Medicas (HU-17, HU-18)
CREATE TABLE AtencionesMedicas (
    idAtencion INT AUTO_INCREMENT PRIMARY KEY,
    idCita INT NOT NULL UNIQUE,
    motivoConsulta TEXT NOT NULL,
    antecedentes TEXT,
    signosVitales TEXT,
    diagnostico TEXT NOT NULL,
    tratamiento TEXT,
    observaciones TEXT,
    FOREIGN KEY (idCita) REFERENCES Citas(idCita)
);

-- 7. Tabla Medicamentos (Módulo Farmacia)
CREATE TABLE Medicamentos (
    idMedicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    concentracion VARCHAR(50),
    presentacion VARCHAR(50),
    stockActual INT DEFAULT 0
);

-- 8. Tabla Recetas (HU-19)
CREATE TABLE Recetas (
    idReceta INT AUTO_INCREMENT PRIMARY KEY,
    idAtencion INT NOT NULL,
    idMedicamento INT NOT NULL,
    cantidad INT NOT NULL,
    indicaciones TEXT NOT NULL,
    FOREIGN KEY (idAtencion) REFERENCES AtencionesMedicas(idAtencion),
    FOREIGN KEY (idMedicamento) REFERENCES Medicamentos(idMedicamento)
);

-- 9. Tabla Examenes de Laboratorio (HU-21)
CREATE TABLE ExamenesLaboratorio (
    idExamen INT AUTO_INCREMENT PRIMARY KEY,
    idAtencion INT NOT NULL,
    tipoExamen VARCHAR(100) NOT NULL,
    resultado TEXT,
    estado VARCHAR(20) DEFAULT 'PENDIENTE',
    FOREIGN KEY (idAtencion) REFERENCES AtencionesMedicas(idAtencion)
);

-- 10. Tabla Comprobantes (HU-25, HU-26)
CREATE TABLE Comprobantes (
    idComprobante INT AUTO_INCREMENT PRIMARY KEY,
    numeroComprobante VARCHAR(20) NOT NULL UNIQUE,
    idAtencion INT NOT NULL,
    montoTotal DECIMAL(10, 2) NOT NULL,
    metodoPago VARCHAR(50) NOT NULL,
    fechaHora DATETIME NOT NULL,
    FOREIGN KEY (idAtencion) REFERENCES AtencionesMedicas(idAtencion)
);

-- 11. Tabla Auditoria (RN-06)
CREATE TABLE Auditoria (
    idAuditoria INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    fechaHora DATETIME NOT NULL,
    modulo VARCHAR(50) NOT NULL,
    operacion VARCHAR(100) NOT NULL
);

-- Inserción de un usuario administrador por defecto (Contraseña de ejemplo: Admin123!)
INSERT INTO Usuarios (dni, nombres, apellidos, nombreUsuario, contrasena, rol, activo) 
VALUES ('12345678', 'Super Admin', 'Sistema', 'admin', '3eb3fe66b31e3b4d10fa70b5cad49c7112294af6ae4e476a1c405155d45aa121', 'ADMINISTRADOR', 1);