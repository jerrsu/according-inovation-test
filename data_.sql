INSERT INTO trip_status (id,status) VALUES
(1,'IDLE'),
(2,'ON GOING'),
(3,'COMPLETE');

INSERT INTO vehicle (id, plate_number, model, status_id, created_at, updated_at) VALUES
('550e8400-e29b-41d4-a716-446655440000', 'B 1234 AB', 'Toyota Avanza', 1, NOW(), NOW()),
('550e8400-e29b-41d4-a716-446655440001', 'B 5678 CD', 'Honda Brio', 1, NOW(), NOW()),
('550e8400-e29b-41d4-a716-446655440002', 'B 9101 EF', 'Suzuki Ertiga', 1, NOW(), NOW()),
('550e8400-e29b-41d4-a716-446655440003', 'B 1121 GH', 'Daihatsu Xenia', 1, NOW(), NOW()),
('550e8400-e29b-41d4-a716-446655440004', 'B 3141 IJ', 'Mitsubishi Xpander', 1, NOW(), NOW());

