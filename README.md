# personaGui
CRUD GUI JAVA MVC


MYSQL
CREATE TABLE `persona` (
  `id` int(7) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `profesion` varchar(50) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
)
