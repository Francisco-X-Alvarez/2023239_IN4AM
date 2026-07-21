create database if not exists proyecto_taller_in4am;
use proyecto_taller_in4am;

-- usuarios
create table if not exists usuarios (
    id_usuario int auto_increment primary key,
    nombre_completo varchar(100) not null,
    username varchar(50) not null unique,
    email varchar(100) not null unique,
    password varchar(255) not null
);

-- create
drop procedure if exists sp_registrarusuario;
delimiter $$
	create procedure sp_registrarusuario(in nombre_completo_p varchar(100),
										in username_p varchar(50),
										in email_p varchar(100),
										in password_p varchar(255))
                                        
	begin
		insert into usuarios(nombre_completo, username, email, password)
			values (nombre_completo_p, username_p, email_p, password_p);
	end$$
delimiter ;

-- read
drop procedure if exists sp_listarusuarios;
delimiter $$
	create procedure sp_listarusuarios()
	begin
		select id_usuario, 
			nombre_completo, 
			username, 
			email 
		from usuarios;
	end$$
delimiter ;

-- login
drop procedure if exists sp_autenticarusuario;
delimiter $$
	create procedure sp_autenticarusuario(in username_p varchar(50),
										in password_p varchar(255))
                                        
	begin
		select 
			id_usuario, 
			nombre_completo, 
			username, 
			email 
		from usuarios 
			where username = username_p and password = password_p;
	end$$
delimiter ;