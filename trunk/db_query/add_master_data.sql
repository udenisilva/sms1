/* ##################Add Admin User##################### */
INSERT INTO `nbrodb`.`system_user`(`user_id`,`activestatus`,`email_address`,`password`,`profile_image_url`,`user_display_name`,`user_name`,`version_id`,`designation`,`staff_id`,`staff_name`) VALUES(1,0,'admin@gmail.com',123,null,'admin','admin',0,'admin',123,'Admin');
INSERT INTO `nbrodb`.`user_role`(`user_role_id`,`user_role_type`,`version_id`) VALUES(1,1,0);
INSERT INTO `nbrodb`.`user_role`(`user_role_id`,`user_role_type`,`version_id`) VALUES(2,2,0);
INSERT INTO `nbrodb`.`system_user_roles`(`user_id`,`user_role_id`) VALUES(1,2);
INSERT INTO `nbrodb`.`system_user_roles`(`user_id`,`user_role_id`) VALUES(1,1);
 
/* ##################Add sequence_number##################### */
INSERT INTO `nbrodb`.`sequence_number`(`id`,`currentSequenceNumber`,`description`,`versionId`) VALUES(1,100,'G1',0);
INSERT INTO `nbrodb`.`sequence_number`(`id`,`currentSequenceNumber`,`description`,`versionId`) VALUES(2,100,'G2',0);
INSERT INTO `nbrodb`.`sequence_number`(`id`,`currentSequenceNumber`,`description`,`versionId`) VALUES(3,100,'G3',0);
INSERT INTO `nbrodb`.`sequence_number`(`id`,`currentSequenceNumber`,`description`,`versionId`) VALUES(4,100,'G4',0);
 