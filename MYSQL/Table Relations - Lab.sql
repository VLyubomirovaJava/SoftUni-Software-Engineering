create table mountains(
`id` int primary key auto_increment,
`name` varchar (45) );
create table `peaks`(
`id` int primary key auto_increment,
`name` varchar (45),
`mountain_id` int,
constraint `fk_peaks_mountains`
foreign key (`mountain_id`)
references mountains(id)
); 
drop tables mountains, peaks;

#2
SELECT driver_id,vehicle_type,
concat_ws(' ',first_name,last_name) as `driver_name`
from campers as c
join 
vehicles as v on v.driver_id=c.id;

#3
SELECT starting_point as route_starting_point,
end_point as route_ending_point,
leader_id,
concat_ws(' ',c.first_name,c.last_name) as leader_name
from routes as r
join 
campers as c on c.id=r.leader_id;

#4
create table `mountains`(
`id` int primary key auto_increment,
`name` varchar (45) );
create table `peaks`(
`id` int primary key auto_increment,
`name` varchar (45),
`mountain_id` int,
constraint `fk_mountains_peaks`
foreign key (`mountain_id`)
references mountains(`id`)
on delete cascade
);
