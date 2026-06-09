

DROP DATABASE IF EXISTS escuela_piano;
CREATE DATABASE escuela_piano CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE escuela_piano;

DROP TABLE IF EXISTS profesor;
CREATE TABLE profesor (
    id_profesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

INSERT INTO profesor (nombre, especialidad, telefono, email) VALUES
('Ana García', 'Piano clásico', '55-1234-5678', 'ana.garcia@example.com'),
('Luis Pérez', 'Teoría musical', '55-2345-6789', 'luis.perez@example.com'),
('María López', 'Jazz y arreglos', '55-3456-7890', 'maria.lopez@example.com'),
('Carlos Rivera', 'Técnica avanzada', '55-4567-8901', 'carlos.rivera@example.com'),
('Sofía Torres', 'Repertorio contemporáneo', '55-5678-9012', 'sofia.torres@example.com');

DROP TABLE IF EXISTS instrumento;
CREATE TABLE instrumento (
    id_instrumento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    nivel_recomendado VARCHAR(50),
    descripcion VARCHAR(200)
);

INSERT INTO instrumento (nombre, tipo, nivel_recomendado, descripcion) VALUES
('Piano de cola', 'Piano', 'Avanzado', 'Instrumento ideal para clases de interpretación clásica.'),
('Teclado electrónico', 'Teclado', 'Inicial', 'Perfecto para principiantes y prácticas en casa.'),
('Piano vertical', 'Piano', 'Intermedio', 'Piano acústico para estudio y conciertos pequeños.'),
('Piano digital', 'Piano', 'Todos', 'Instrumento versátil con metrónomo y pads de ritmo integrados.'),
('Sintetizador', 'Teclado', 'Intermedio', 'Para exploración de sonidos modernos y arreglos.' );


DROP TABLE IF EXISTS estudiante;
CREATE TABLE estudiante (
    id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    nivel VARCHAR(50) NOT NULL,
    instrumento VARCHAR(100) NOT NULL,
    id_profesor INT NOT NULL,
    FOREIGN KEY (id_profesor) REFERENCES profesor(id_profesor)
);

INSERT INTO estudiante (nombre, edad, nivel, instrumento, id_profesor) VALUES
('Juliana Martínez', 12, 'Inicial', 'Teclado electrónico', 1),
('Diego Hernández', 15, 'Intermedio', 'Piano vertical', 2),
('Valentina Ruiz', 13, 'Inicial', 'Piano digital', 5),
('Marco Sánchez', 17, 'Avanzado', 'Piano de cola', 4),
('Camila Flores', 14, 'Intermedio', 'Sintetizador', 3);


SELECT * FROM profesor;
SELECT * FROM instrumento;
SELECT * FROM estudiante;
