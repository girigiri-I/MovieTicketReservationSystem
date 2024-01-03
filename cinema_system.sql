/*
 Navicat Premium Data Transfer

 Source Server         : MySQL_Cicero
 Source Server Type    : MySQL
 Source Server Version : 80035 (8.0.35)
 Source Host           : localhost:3306
 Source Schema         : cinema_system

 Target Server Type    : MySQL
 Target Server Version : 80035 (8.0.35)
 File Encoding         : 65001

 Date: 03/01/2024 16:19:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for booking_info
-- ----------------------------
DROP TABLE IF EXISTS `booking_info`;
CREATE TABLE `booking_info`  (
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schedule_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `booking_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `booking_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`booking_id`) USING BTREE,
  INDEX `user_name`(`user_name` ASC) USING BTREE,
  INDEX `schedule_id`(`schedule_id` ASC) USING BTREE,
  CONSTRAINT `booking_info_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `booking_info_ibfk_2` FOREIGN KEY (`schedule_id`) REFERENCES `movie_schedule` (`schedule_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booking_info
-- ----------------------------

-- ----------------------------
-- Table structure for movie_info
-- ----------------------------
DROP TABLE IF EXISTS `movie_info`;
CREATE TABLE `movie_info`  (
  `id` int NOT NULL,
  `movie_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `synopsis` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `show_date` date NULL DEFAULT NULL,
  `length_time` int NULL DEFAULT NULL,
  `director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cast` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `language_subtitles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isIMAX` tinyint(1) NULL DEFAULT NULL,
  `playbill` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_info
-- ----------------------------
INSERT INTO `movie_info` VALUES (1, 'Batman Begins', 'In the wake of his parents\' murder, disillusioned industrial heir Bruce Wayne (Christian Bale) travels the world seeking the means to fight injustice and turn fear against those who prey on the fearful. He returns to Gotham and unveils his alter-ego: Batman, a masked crusader who uses his strength, intellect and an array of high tech deceptions to fight the sinister forces that threaten the city.', '2023-11-23', 140, 'Christopher Nolan', 'Christian Bale, Michael Caine, Liam Neeson, Katie Holmes, Gary Oldman, Cillian Murphy, Morgan Freeman', 'English(Chinese Subtitles)', 1, NULL);
INSERT INTO `movie_info` VALUES (2, 'The Dark Knight', 'With the help of Lieutenant Jim Gordon and District Attorney Harvey Dent, Batman sets out to destroy organized crime in Gotham for good. The triumvirate proves to be effective, but they soon find themselves prey to a rising criminal mastermind known as the Joker, who thrusts Gotham into anarchy and forces the Dark Knight ever closer to crossing the fine line between hero and vigilante.', '2023-11-23', 152, 'Christopher Nolan', 'Christian Bale, Michael Caine, Heath Ledger, Gary Oldman, Aaron Eckhart, Maggie Gyllenhaal, Morgan Freeman', 'English(Chinese Subtitles)', 1, NULL);
INSERT INTO `movie_info` VALUES (3, 'The Dark Knight Rises', 'It has been eight years since Batman vanished into the night, turning, in that instant, from hero to fugitive. Assuming the blame for the death of D.A. Harvey Dent, the Dark Knight sacrificed everything for what he and Commissioner Gordon both hoped was the greater good. For a time the lie worked, as criminal activity in Gotham City was crushed under the weight of the anti-crime Dent Act.\n\nBut everything will change with the arrival of a cunning cat burglar with a mysterious agenda. Far more dangerous, however, is the emergence of Bane, a masked terrorist whose ruthless plans for Gotham drive Bruce out of his self-imposed exile. But even if he dons the cape and cowl again, Batman may be no match for Bane.', '2023-11-23', 164, 'Christopher Nolan', 'Christian Bale, Michael Caine, Gary Oldman, Anne Hathaway, Tom Hardy, Marion Cotillard, Joseph Gordon-Levitt, Morgan Freeman', 'English(Chinese Subtitles)', 1, NULL);
INSERT INTO `movie_info` VALUES (4, 'Napoleon', 'Napoleon is a spectacle-filled action epic that details the checkered rise and fall of the iconic French Emperor Napoleon Bonaparte, played by Oscar-winner Joaquin Phoenix. Against a stunning backdrop of large-scale filmmaking orchestrated by legendary director Ridley Scott, the film captures Bonaparte\'s relentless journey to power through the prism of his addictive, volatile relationship with his one true love, Josephine, showcasing his visionary military and political tactics against some of the most dynamic practical battle sequences ever filmed.', '2023-11-23', 158, 'Ridley Scott', 'Joaquin Phoenix, Vanessa Kirby', 'English(Chinese Subtitles)', 0, NULL);
INSERT INTO `movie_info` VALUES (5, 'April Story', 'Long awaited spring is just around the corner when Uzuki Nirenno bids goodbye to her family and leaves Hokkaido. She is moving to Tokyo to attend a university. A new apartment, a new neighbour, a new bicycle, a new book shop, and a new view adorned by dancing cherry blossoms petals. One day, when introducing herself during her homeroom orientation, Uzuki finds herself unexpectedly embarrassed by an innocent question asked by a fellow student. “Why did you choose this university?” For indeed, Uzuki’s secret motivation was somewhat a frivolous one…This coming-of-age classic from Shunji Iwai is still beautiful and refreshing as it was in 1998.', '2023-11-16', 67, 'Shunji Iwai', 'Takako Matsu, Seiichi Tanabe', 'Japanese(Chinese, English Subtitles)', 0, NULL);
INSERT INTO `movie_info` VALUES (6, 'Trolls Band Together', 'After two films of true friendship and relentless flirting, Poppy (Anna Kendrick) and Branch (Justin Timberlake) are now officially, finally, a couple (#broppy)! As they grow closer, Poppy discovers that Branch has a secret past. He was once part of her favorite boyband phenomenon, BroZone, with his four brothers: Floyd (Golden Globe nominated electropop sensation Troye Sivan), John Dory (Eric André; Sing 2), Spruce (Grammy winner Daveed Diggs; Hamilton) and Clay (Grammy winner Kid Cudi; Don’t Look Up). BroZone disbanded when Branch was still a baby, as did the family, and Branch hasn’t seen his brothers since.\n\nBut when Branch’s bro Floyd is kidnapped for his musical talents by a pair of nefarious pop-star villains—Velvet (Emmy winner Amy Schumer; Trainwreck) and Veneer (Grammy winner and Tony nominee Andrew Rannells; The Book of Mormon)—Branch and Poppy embark on a harrowing and emotional journey to reunite the other brothers and rescue Floyd from a fate even worse than pop-culture obscurity.', '2023-11-23', 91, 'Walt Dohrn', 'Voice Cast: Anna Kendrick, Justin Timberlake, Camila Cabello, Eric André, Amy Schumer', 'English(Chinese Subtitles)', 0, NULL);
INSERT INTO `movie_info` VALUES (7, 'TAYLOR SWIFT | THE ERAS TOUR', 'The cultural phenomenon continues on the big screen! Immerse yourself in this once-in-a-lifetime concert film experience with a breathtaking, cinematic view of the history-making tour. Taylor Swift Eras Tour attire and friendship bracelets are strongly encouraged!\n\nLimited screenings at Broadway Cinemas Circuit will be available from 3 NOVEMBER, on both IMAX and 2D screens, Don’t Miss it!', '2023-11-03', 169, 'Sam Wrench', 'Taylor Swift', 'English(No Subtitles)', 1, NULL);
INSERT INTO `movie_info` VALUES (8, 'Sound of Freedom', 'SOUND OF FREEDOM is a thriller based on the incredible true story of a former government agent turned freedom fighter who embarks on a dangerous mission to rescue dozens of children from human trafficking. This emotionally riveting narrative is a powerful story of heroism and stands as a testament to the tenacious spirit of those who refuse to let evil triumph.', '2023-11-23', 131, 'Alejandro Moneverde', 'Jim Caviezel', 'English(Chinese Subtitles)', 0, NULL);

-- ----------------------------
-- Table structure for movie_schedule
-- ----------------------------
DROP TABLE IF EXISTS `movie_schedule`;
CREATE TABLE `movie_schedule`  (
  `id` int NULL DEFAULT NULL,
  `schedule_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cinema` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schedule_date` date NULL DEFAULT NULL,
  `schedule_time` time NULL DEFAULT NULL,
  `house` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  PRIMARY KEY (`schedule_id`) USING BTREE,
  INDEX `id`(`id` ASC) USING BTREE,
  CONSTRAINT `movie_schedule_ibfk_1` FOREIGN KEY (`id`) REFERENCES `movie_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_schedule
-- ----------------------------
INSERT INTO `movie_schedule` VALUES (1, '001a', 'KLN', 'B+ cinema MOKO (Mong Kok East)', '2023-11-27', '10:35:00', 'IMAX', 130);
INSERT INTO `movie_schedule` VALUES (1, '001b', 'NT', 'MY CINEMA YOHO MALL', '2023-11-27', '10:35:00', 'IMAX', 130);
INSERT INTO `movie_schedule` VALUES (2, '002a', 'KLN', 'B+ cinema MOKO (Mong Kok East)', '2023-11-27', '19:00:00', 'IMAX', 160);
INSERT INTO `movie_schedule` VALUES (2, '002b', 'NT', 'MY CINEMA YOHO MALL', '2023-11-27', '19:00:00', 'IMAX', 160);
INSERT INTO `movie_schedule` VALUES (3, '003a', 'KLN', 'B+ cinema MOKO (Mong Kok East)', '2023-11-27', '21:55:00', 'IMAX', 160);
INSERT INTO `movie_schedule` VALUES (3, '003b', 'NT', 'MY CINEMA YOHO MALL', '2023-11-27', '21:55:00', 'IMAX', 160);
INSERT INTO `movie_schedule` VALUES (4, '004a', 'HK', 'MOViE MOViE Pacific Place (Admiralty)', '2023-11-26', '21:35:00', 'MM Plus', 70);
INSERT INTO `movie_schedule` VALUES (4, '004b', 'HK', 'MOViE MOViE Cityplaza (Taikoo Shing)', '2023-11-26', '21:30:00', 'House 5', 70);
INSERT INTO `movie_schedule` VALUES (4, '004c', 'HK', 'PALACE ifc', '2023-11-26', '21:15:00', 'House 3', 70);
INSERT INTO `movie_schedule` VALUES (5, '005a', 'HK', 'PALACE ifc', '2023-11-26', '14:45:00', 'House 4', 130);
INSERT INTO `movie_schedule` VALUES (5, '005b', 'KLN', 'PREMIERE ELEMENTS', '2023-11-26', '16:10:00', 'House 8', 110);
INSERT INTO `movie_schedule` VALUES (5, '005c', 'KLN', 'CINEMATHEQUE', '2023-11-26', '18:40:00', 'House 1', 95);
INSERT INTO `movie_schedule` VALUES (6, '006a', 'HK', 'MOViE MOViE Pacific Place (Admiralty)', '2023-11-26', '13:20:00', 'House 5', 130);
INSERT INTO `movie_schedule` VALUES (6, '006b', 'HK', 'MOViE MOViE Cityplaza (Taikoo Shing)', '2023-11-26', '13:30:00', 'House 2', 100);
INSERT INTO `movie_schedule` VALUES (6, '006c', 'HK', 'PALACE ifc', '2023-11-26', '12:30:00', 'House 1', 130);
INSERT INTO `movie_schedule` VALUES (6, '006d', 'KLN', 'PREMIERE ELEMENTS', '2023-11-26', '12:15:00', 'House 10', 110);
INSERT INTO `movie_schedule` VALUES (7, '007a', 'KLN', 'B+ cinema MOKO (Mong Kok East)', '2023-11-26', '18:40:00', 'IMAX', 200);
INSERT INTO `movie_schedule` VALUES (7, '007b', 'NT', 'MY CINEMA YOHO MALL', '2023-11-26', '18:40:00', 'IMAX', 200);
INSERT INTO `movie_schedule` VALUES (8, '008a', 'HK', 'MOViE MOViE Pacific Place (Admiralty)', '2023-11-26', '21:55:00', 'House 4', 50);
INSERT INTO `movie_schedule` VALUES (8, '008b', 'HK ', 'MOViE MOViE Cityplaza (Taikoo Shing)', '2023-11-26', '11:00:00', 'House 2', 60);
INSERT INTO `movie_schedule` VALUES (8, '008c', 'HK', 'PALACE ifc', '2023-11-26', '13:15:00', 'House 4', 130);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111', '1', '111111', '1', '1@163.com');
INSERT INTO `user` VALUES ('aaa', 'aaa', 'a123456', '12345678', '1234567890@link.cuhk.edu.hk');

SET FOREIGN_KEY_CHECKS = 1;
