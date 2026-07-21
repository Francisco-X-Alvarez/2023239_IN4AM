use proyecto_taller_in4am;

insert ignore into usuarios (nombre_completo, username, email, password) 
values ('francisco alvarez', 'falvarez', 'francisco@kinal.edu.gt', 'clave123');

insert ignore into usuarios (nombre_completo, username, email, password) 
values ('kenneth ramos', 'kramos', 'kenneth@kinal.edu.gt', 'admin123');

insert ignore into usuarios (nombre_completo, username, email, password) 
values ('edmond perez', 'eperez', 'edmond@kinal.edu.gt', 'edmond2026');

select * from usuarios;

call sp_registrarusuario('nuevo estudiante', 'nestudiante', 'nestudiante@kinal.edu.gt', 'pass123');
call sp_listarusuarios();
call sp_autenticarusuario('falvarez', 'clave123');