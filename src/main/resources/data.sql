-- Inserta Category
INSERT INTO category (category_id, category_name, category_description) VALUES (1,'Tecnologia', 'Dispositivos electrónicos, hardware y gadgets de última generación.');
INSERT INTO category (category_id, category_name, category_description) VALUES (2,'Hogar y Muebles', 'Artículos para decoración, mobiliario y organización de la casa.');
INSERT INTO category (category_id, category_name, category_description) VALUES (3,'Deportes y Fitness', 'Equipamiento deportivo, ropa técnica y accesorios para ejercicio.');

-- Insertar vendor
INSERT INTO vendor (vendor_id, vendor_name, vendor_location, category_id) VALUES
(1, 'TechNova Solutions', 'Bogotá', 1),
(2, 'ElectroSmart Colombia', 'Medellín', 1),
(3, 'Gadget World', 'Cali', 1),
(4, 'Muebles El Roble', 'Bogotá', 2),
(5, 'DecoCasa Hogar', 'Barranquilla', 2),
(6, 'Hogar & Estilo', 'Pereira', 2),
(7, 'FitZone Store', 'Manizales', 3),
(8, 'ProFitness Colombia', 'Bogotá', 3),
(9, 'SportLife Center', 'Cali', 3),
(10, 'ActiveWear & Fitness', 'Bucaramanga', 3);



INSERT INTO Product (
  product_id, product_name, product_price, product_currency, product_stock,
  product_condition, product_description, product_free_shipping,
  product_brand, product_reference, product_quantity, product_images,
  category_id, vendor_id
) VALUES

-- ======================
-- TECNOLOGÍA (category_id = 1)
-- ======================
(1, 'Laptop Gamer 15', 5500000, 'COP', 1, 1, 'Laptop gamer con RTX y 16GB RAM.', 1,
 'Acer', 'AC-GM-15', 10,
 '["https://http2.mlstatic.com/D_6543-MLA.jpg","https://http2.mlstatic.com/D_6544-MLA.jpg"]',
 1, 1),

(2, 'Smartphone Android 5G', 2800000, 'COP', 1, 1, 'Celular 5G con cámara de 64MP.', 1,
 'Samsung', 'SM-A54', 25,
 '["https://http2.mlstatic.com/D_1234-MLA.jpg"]',
 1, 1),

(3, 'Audífonos Inalámbricos', 450000, 'COP', 1, 1, 'Audífonos bluetooth con cancelación de ruido.', 0,
 'Sony', 'SN-WH1000', 40,
 '["https://http2.mlstatic.com/D_2233-MLA.jpg"]',
 1, 2),

(4, 'Teclado Mecánico RGB', 320000, 'COP', 1, 1, 'Teclado mecánico switches rojos.', 1,
 'Logitech', 'LG-MECH-RGB', 30,
 '["https://http2.mlstatic.com/D_3322-MLA.jpg"]',
 1, 2),

(5, 'Mouse Gamer', 180000, 'COP', 1, 1, 'Mouse gamer 16000 DPI.', 1,
 'Razer', 'RZ-VIPER', 50,
 '["https://http2.mlstatic.com/D_4455-MLA.jpg"]',
 1, 3),

(6, 'Monitor 27 Pulgadas', 1350000, 'COP', 1, 1, 'Monitor QHD 144Hz.', 0,
 'LG', 'LG-27QHD', 15,
 '["https://http2.mlstatic.com/D_5566-MLA.jpg"]',
 1, 3),

(7, 'Tablet 10"', 1200000, 'COP', 1, 1, 'Tablet ideal para estudio y trabajo.', 1,
 'Huawei', 'HW-T10', 20,
 '["https://http2.mlstatic.com/D_6677-MLA.jpg"]',
 1, 1),

(8, 'Disco SSD 1TB', 420000, 'COP', 1, 1, 'SSD NVMe alta velocidad.', 1,
 'Kingston', 'KT-NVME1T', 35,
 '["https://http2.mlstatic.com/D_7788-MLA.jpg"]',
 1, 2),

(9, 'Cámara Web Full HD', 210000, 'COP', 1, 1, 'Cámara 1080p para streaming.', 0,
 'Logitech', 'LG-C920', 18,
 '["https://http2.mlstatic.com/D_8899-MLA.jpg"]',
 1, 3),

(10, 'Router WiFi 6', 650000, 'COP', 1, 1, 'Router WiFi 6 alta cobertura.', 1,
 'TP-Link', 'TP-AX3000', 22,
 '["https://http2.mlstatic.com/D_9900-MLA.jpg"]',
 1, 1),

-- ======================
-- HOGAR Y MUEBLES (category_id = 2)
-- ======================
(11, 'Sofá 3 Puestos', 2800000, 'COP', 1, 1, 'Sofá moderno en tela premium.', 0,
 'DecoCasa', 'DC-SF3', 5,
 '["https://http2.mlstatic.com/D_1111-MLA.jpg"]',
 2, 4),

(12, 'Mesa de Comedor', 1900000, 'COP', 1, 1, 'Mesa de madera para 6 personas.', 0,
 'El Roble', 'ER-MC6', 8,
 '["https://http2.mlstatic.com/D_2222-MLA.jpg"]',
 2, 4),

(13, 'Silla Ergonómica', 980000, 'COP', 1, 1, 'Silla ergonómica reclinable.', 1,
 'Hogar & Estilo', 'HE-SERG', 12,
 '["https://http2.mlstatic.com/D_3333-MLA.jpg"]',
 2, 5),

(14, 'Cama Doble', 2100000, 'COP', 1, 1, 'Cama doble con cabecero.', 0,
 'DecoCasa', 'DC-CD', 6,
 '["https://http2.mlstatic.com/D_4444-MLA.jpg"]',
 2, 5),

(15, 'Escritorio de Oficina', 850000, 'COP', 1, 1, 'Escritorio moderno minimalista.', 1,
 'OfficeHome', 'OH-ESC', 14,
 '["https://http2.mlstatic.com/D_5555-MLA.jpg"]',
 2, 6),

(16, 'Lámpara Decorativa', 220000, 'COP', 1, 1, 'Lámpara LED decorativa.', 1,
 'LightHome', 'LH-LAMP', 30,
 '["https://http2.mlstatic.com/D_6666-MLA.jpg"]',
 2, 6),

(17, 'Biblioteca Madera', 1400000, 'COP', 1, 1, 'Biblioteca de 5 niveles.', 0,
 'El Roble', 'ER-BIB', 7,
 '["https://http2.mlstatic.com/D_7777-MLA.jpg"]',
 2, 4),

(18, 'Mesa de Noche', 420000, 'COP', 1, 1, 'Mesa de noche con cajón.', 1,
 'DecoCasa', 'DC-MN', 20,
 '["https://http2.mlstatic.com/D_8888-MLA.jpg"]',
 2, 5),

(19, 'Zapatero', 560000, 'COP', 1, 1, 'Zapatero organizador.', 1,
 'Hogar & Estilo', 'HE-ZAP', 18,
 '["https://http2.mlstatic.com/D_9999-MLA.jpg"]',
 2, 6),

(20, 'Espejo Decorativo', 390000, 'COP', 1, 1, 'Espejo redondo moderno.', 1,
 'DecoCasa', 'DC-ESP', 16,
 '["https://http2.mlstatic.com/D_1010-MLA.jpg"]',
 2, 5),

-- ======================
-- DEPORTES Y FITNESS (category_id = 3)
-- ======================
(21, 'Bicicleta Estática', 2200000, 'COP', 1, 1, 'Bicicleta para ejercicio en casa.', 0,
 'FitZone', 'FZ-BIKE', 6,
 '["https://http2.mlstatic.com/D_2020-MLA.jpg"]',
 3, 7),

(22, 'Mancuernas 20kg', 480000, 'COP', 1, 1, 'Set de mancuernas ajustables.', 1,
 'ProFitness', 'PF-M20', 25,
 '["https://http2.mlstatic.com/D_3030-MLA.jpg"]',
 3, 8),

(23, 'Caminadora Eléctrica', 3500000, 'COP', 1, 1, 'Caminadora plegable.', 0,
 'SportLife', 'SL-CAM', 4,
 '["https://http2.mlstatic.com/D_4040-MLA.jpg"]',
 3, 9),

(24, 'Colchoneta Yoga', 150000, 'COP', 1, 1, 'Colchoneta antideslizante.', 1,
 'ActiveWear', 'AW-YOGA', 50,
 '["https://http2.mlstatic.com/D_5050-MLA.jpg"]',
 3, 10),

(25, 'Bandas Elásticas', 90000, 'COP', 1, 1, 'Bandas para entrenamiento.', 1,
 'ProFitness', 'PF-BAND', 60,
 '["https://http2.mlstatic.com/D_6060-MLA.jpg"]',
 3, 8),

(26, 'Guantes de Entrenamiento', 120000, 'COP', 1, 1, 'Guantes para pesas.', 1,
 'FitZone', 'FZ-GUANT', 40,
 '["https://http2.mlstatic.com/D_7070-MLA.jpg"]',
 3, 7),

(27, 'Balón de Fútbol', 110000, 'COP', 1, 1, 'Balón profesional.', 1,
 'SportLife', 'SL-BALL', 35,
 '["https://http2.mlstatic.com/D_8080-MLA.jpg"]',
 3, 9),

(28, 'Rueda Abdominal', 85000, 'COP', 1, 1, 'Rueda para abdomen.', 1,
 'ActiveWear', 'AW-ABS', 45,
 '["https://http2.mlstatic.com/D_9090-MLA.jpg"]',
 3, 10),

(29, 'Chaleco con Peso', 420000, 'COP', 1, 1, 'Chaleco ajustable con peso.', 0,
 'ProFitness', 'PF-CHAL', 12,
 '["https://http2.mlstatic.com/D_1112-MLA.jpg"]',
 3, 8),

(30, 'Cuerda para Saltar', 60000, 'COP', 1, 1, 'Cuerda ajustable fitness.', 1,
 'FitZone', 'FZ-CUERDA', 70,
 '["https://http2.mlstatic.com/D_1313-MLA.jpg"]',
 3, 7);


INSERT INTO attribute(attribute_id, product_id, attribute_name, attribute_value) VALUES

-- ======================
-- PRODUCTOS TECNOLOGÍA
-- ======================
(1, 1, 'RAM', '16GB'),
(2, 1, 'Procesador', 'Intel Core i7'),

(3, 2, 'Almacenamiento', '256GB'),
(4, 2, 'Cámara', '64MP'),

(5, 3, 'Conectividad', 'Bluetooth 5.0'),
(6, 3, 'Batería', '30 horas'),

(7, 4, 'Tipo Switch', 'Rojo'),
(8, 4, 'Iluminación', 'RGB'),

(9, 5, 'DPI', '16000'),
(10, 5, 'Conexión', 'USB'),

(11, 6, 'Resolución', '2560x1440'),
(12, 6, 'Frecuencia', '144Hz'),

(13, 7, 'Pantalla', '10 pulgadas'),
(14, 7, 'Sistema Operativo', 'Android'),

(15, 8, 'Capacidad', '1TB'),
(16, 8, 'Tipo', 'NVMe'),

(17, 9, 'Resolución', 'Full HD'),
(18, 9, 'Micrófono', 'Integrado'),

(19, 10, 'Estándar', 'WiFi 6'),
(20, 10, 'Velocidad', '3000 Mbps'),

-- ======================
-- HOGAR Y MUEBLES
-- ======================
(21, 11, 'Material', 'Tela'),
(22, 11, 'Capacidad', '3 personas'),

(23, 12, 'Material', 'Madera'),
(24, 12, 'Capacidad', '6 personas'),

(25, 13, 'Material', 'Malla'),
(26, 13, 'Soporte Lumbar', 'Sí'),

(27, 14, 'Tamaño', 'Doble'),
(28, 14, 'Material', 'Madera'),

(29, 15, 'Material', 'MDF'),
(30, 15, 'Uso', 'Oficina'),

(31, 16, 'Tipo Luz', 'LED'),
(32, 16, 'Color', 'Blanco cálido'),

(33, 17, 'Niveles', '5'),
(34, 17, 'Material', 'Madera'),

(35, 18, 'Material', 'Madera'),
(36, 18, 'Cajones', '1'),

(37, 19, 'Capacidad', '12 pares'),
(38, 19, 'Material', 'Plástico'),

(39, 20, 'Forma', 'Redondo'),
(40, 20, 'Diámetro', '80 cm'),

-- ======================
-- DEPORTES Y FITNESS
-- ======================
(41, 21, 'Tipo', 'Estática'),
(42, 21, 'Resistencia', 'Magnética'),

(43, 22, 'Peso Total', '20 kg'),
(44, 22, 'Material', 'Hierro'),

(45, 23, 'Velocidad Máxima', '14 km/h'),
(46, 23, 'Plegable', 'Sí'),

(47, 24, 'Espesor', '6 mm'),
(48, 24, 'Material', 'EVA'),

(49, 25, 'Niveles', '5'),
(50, 25, 'Resistencia', 'Alta'),

(51, 26, 'Material', 'Cuero sintético'),
(52, 26, 'Talla', 'M'),

(53, 27, 'Tamaño', 'N°5'),
(54, 27, 'Material', 'PU'),

(55, 28, 'Material', 'Plástico'),
(56, 28, 'Agarre', 'Antideslizante'),

(57, 29, 'Peso Máximo', '20 kg'),
(58, 29, 'Ajustable', 'Sí'),

(59, 30, 'Longitud', '3 metros'),
(60, 30, 'Material', 'PVC');

ALTER TABLE product ALTER COLUMN product_id RESTART WITH 31;
ALTER TABLE attribute ALTER COLUMN attribute_id RESTART WITH 61;


