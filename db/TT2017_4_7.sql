-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.19-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 dbteaching 的数据库结构
CREATE DATABASE IF NOT EXISTS `dbteaching` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbteaching`;


-- 导出  表 dbteaching.d_class 结构
CREATE TABLE IF NOT EXISTS `d_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_inyear` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL COMMENT 'Majorid',
  `class_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_class 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `d_class` DISABLE KEYS */;
REPLACE INTO `d_class` (`class_id`, `class_inyear`, `subject_id`, `class_num`) VALUES
	(4, 2015, 1, 1),
	(5, 2016, 2, 3),
	(6, 2015, 1, 2),
	(7, 2016, 2, 4);
/*!40000 ALTER TABLE `d_class` ENABLE KEYS */;


-- 导出  表 dbteaching.d_exam 结构
CREATE TABLE IF NOT EXISTS `d_exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_id` int(11) DEFAULT NULL,
  `subject_id` int(11) NOT NULL,
  `exam_time` varchar(50) NOT NULL,
  `exam_ab` varchar(50) DEFAULT NULL,
  `exam_num` int(11) NOT NULL,
  `exam_mark` int(11) NOT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_exam 的数据：~14 rows (大约)
/*!40000 ALTER TABLE `d_exam` DISABLE KEYS */;
REPLACE INTO `d_exam` (`exam_id`, `major_id`, `subject_id`, `exam_time`, `exam_ab`, `exam_num`, `exam_mark`) VALUES
	(1, 1, 3, '2015-07-01', 'A', 4, 100),
	(2, 1, 3, '2016-12-21', 'A', 10, 80),
	(3, 3, 7, '2017-04-15', 'A', 14, 100),
	(5, 0, 6, '2016-10-10', 'A', 6, 100),
	(6, 0, 1, '1', '1', 3, 100),
	(12, 0, 2, '2016-07', 'a', 3, 100),
	(14, 1, 3, '2016-07', 'b', 3, 100),
	(15, 1, 3, '2016-05', 'b', 3, 120),
	(16, 0, 3, '2016-01', 'a', 1, 100),
	(17, 0, 3, '2016-01', 'a', 1, 100),
	(18, 0, 3, '2016-01', 'a', 1, 100),
	(19, 0, 3, '2016-07', 'a', 3, 100),
	(20, 0, 3, '2016-01', 'a', 1, 100),
	(21, 0, 3, '2016-01', 'a', 2, 100);
/*!40000 ALTER TABLE `d_exam` ENABLE KEYS */;


-- 导出  表 dbteaching.d_lesson 结构
CREATE TABLE IF NOT EXISTS `d_lesson` (
  `lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  `lesson_num` int(11) NOT NULL,
  `lesson_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`lesson_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_lesson 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `d_lesson` DISABLE KEYS */;
REPLACE INTO `d_lesson` (`lesson_id`, `subject_id`, `lesson_num`, `lesson_date`) VALUES
	(1, 3, 1, NULL),
	(2, 3, 2, NULL),
	(3, 3, 3, NULL),
	(4, 3, 4, NULL),
	(5, 4, 1, NULL),
	(6, 4, 2, NULL),
	(7, 4, 3, NULL);
/*!40000 ALTER TABLE `d_lesson` ENABLE KEYS */;


-- 导出  表 dbteaching.d_major 结构
CREATE TABLE IF NOT EXISTS `d_major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(50) NOT NULL,
  `major_intro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_major 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `d_major` DISABLE KEYS */;
REPLACE INTO `d_major` (`major_id`, `major_name`, `major_intro`) VALUES
	(1, '软件工程', '为未来从事JAVAweb软件开发，培养人才'),
	(2, '集成电路', '为未来从事集成电路工作，培养人才'),
	(3, '法学', '为未来律师工作，培养人才'),
	(5, '电学', '111测试用电学'),
	(6, 'sdsd', 'dsds'),
	(7, 'sdsd', 'dsdd'),
	(8, 'dd111', '2222'),
	(16, 'dsf答复v', '43543热点'),
	(17, 'mjh不同', '怀疑你有 '),
	(18, ' 十中文', '桂高铁'),
	(19, 'ggfgfh', '这里写内容'),
	(20, 'zzzz', 'zzzzz');
/*!40000 ALTER TABLE `d_major` ENABLE KEYS */;


-- 导出  表 dbteaching.d_question 结构
CREATE TABLE IF NOT EXISTS `d_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_exam` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `question_mark` int(11) DEFAULT NULL,
  `question_hard` int(11) DEFAULT NULL,
  `question_text` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_question 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `d_question` DISABLE KEYS */;
REPLACE INTO `d_question` (`question_id`, `question_exam`, `exam_id`, `question_mark`, `question_hard`, `question_text`) VALUES
	(1, 1, 1, 20, 4, 'text1'),
	(2, 2, 1, 15, 1, 'text2'),
	(4, 4, 2, 40, 3, '试卷2'),
	(5, 1, 12, 0, 0, NULL),
	(6, 2, 12, 0, 0, NULL),
	(7, 3, 12, 0, 0, NULL),
	(8, 1, 13, 0, 0, NULL),
	(9, 2, 13, 0, 0, NULL),
	(10, 3, 13, 0, 0, NULL),
	(11, 1, 14, 25, 10, NULL),
	(12, 2, 14, 0, 0, NULL),
	(13, 3, 14, 0, 0, NULL),
	(14, 1, 15, 0, 0, NULL),
	(15, 2, 15, 0, 0, NULL),
	(16, 3, 15, 0, 0, NULL),
	(18, 1, 16, 0, 0, NULL),
	(19, 1, 16, 0, 0, NULL),
	(20, 1, 16, 0, 0, NULL),
	(21, 1, 19, 0, 0, NULL),
	(22, 2, 19, 0, 0, NULL),
	(23, 3, 19, 0, 0, NULL),
	(24, 1, 16, 0, 0, NULL),
	(25, 1, 16, 0, 0, NULL),
	(26, 2, 16, 0, 0, NULL),
	(27, 3, 1, 30, 4, NULL),
	(28, 4, 1, 20, 4, NULL);
/*!40000 ALTER TABLE `d_question` ENABLE KEYS */;


-- 导出  表 dbteaching.d_student 结构
CREATE TABLE IF NOT EXISTS `d_student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(50) NOT NULL,
  `stu_sex` varchar(50) DEFAULT NULL,
  `stu_date` varchar(50) NOT NULL,
  `major_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `stu_inyear` varchar(50) NOT NULL,
  `stu_pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_student 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `d_student` DISABLE KEYS */;
REPLACE INTO `d_student` (`stu_id`, `stu_name`, `stu_sex`, `stu_date`, `major_id`, `class_id`, `stu_inyear`, `stu_pwd`) VALUES
	(1, '12', '12', '12', 1, 4, '2008', '12'),
	(2, '23', '23', '23', 1, 4, '2008', '23'),
	(3, '323', '44', '23', 1, 4, '2008', '34'),
	(4, '学生1', '男', '2000-1-1', 1, 5, '2018', '111111');
/*!40000 ALTER TABLE `d_student` ENABLE KEYS */;


-- 导出  表 dbteaching.d_stu_all 结构
CREATE TABLE IF NOT EXISTS `d_stu_all` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `test_mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_stu_all 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `d_stu_all` DISABLE KEYS */;
REPLACE INTO `d_stu_all` (`test_id`, `stu_id`, `exam_id`, `test_mark`) VALUES
	(1, 1, 3, 64),
	(2, 2, 3, 55),
	(3, 1, 2, 77),
	(4, 3, 3, 54),
	(6, 1, 1, 60);
/*!40000 ALTER TABLE `d_stu_all` ENABLE KEYS */;


-- 导出  表 dbteaching.d_stu_exam 结构
CREATE TABLE IF NOT EXISTS `d_stu_exam` (
  `stex_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `stex_mark` int(11) NOT NULL,
  PRIMARY KEY (`stex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_stu_exam 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `d_stu_exam` DISABLE KEYS */;
REPLACE INTO `d_stu_exam` (`stex_id`, `stu_id`, `question_id`, `stex_mark`) VALUES
	(1, 2, 1, 12),
	(2, 2, 2, 13),
	(3, 3, 4, 15),
	(4, 2, 4, 2),
	(21, 1, 1, 20),
	(22, 1, 2, 20),
	(23, 1, 27, 10),
	(24, 1, 28, 10);
/*!40000 ALTER TABLE `d_stu_exam` ENABLE KEYS */;


-- 导出  表 dbteaching.d_stu_feedback 结构
CREATE TABLE IF NOT EXISTS `d_stu_feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `feedback_time` varchar(200) DEFAULT NULL,
  `feedback_content` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_stu_feedback 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `d_stu_feedback` DISABLE KEYS */;
REPLACE INTO `d_stu_feedback` (`feedback_id`, `stu_id`, `subject_id`, `lesson_id`, `feedback_time`, `feedback_content`) VALUES
	(1, 1, 3, 1, '2017-04-01 16:34:27', '输出HelloWorld'),
	(2, 11, 4, 3, '2017-04-03 18:55:39', '这里写内容sdsadsadsad');
/*!40000 ALTER TABLE `d_stu_feedback` ENABLE KEYS */;


-- 导出  表 dbteaching.d_stu_lesson 结构
CREATE TABLE IF NOT EXISTS `d_stu_lesson` (
  `stle_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `stle_work` int(11) NOT NULL,
  PRIMARY KEY (`stle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_stu_lesson 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `d_stu_lesson` DISABLE KEYS */;
REPLACE INTO `d_stu_lesson` (`stle_id`, `stu_id`, `lesson_id`, `stle_work`) VALUES
	(1, 1, 1, 1),
	(2, 2, 1, 1),
	(3, 3, 1, 0),
	(4, 1, 2, 1),
	(5, 1, 3, 1),
	(6, 1, 4, 0),
	(7, 1, 1, 1),
	(8, 1, 5, 1);
/*!40000 ALTER TABLE `d_stu_lesson` ENABLE KEYS */;


-- 导出  表 dbteaching.d_stu_work 结构
CREATE TABLE IF NOT EXISTS `d_stu_work` (
  `stwk_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  `stwk_mark` int(11) DEFAULT NULL,
  `stwk_text` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`stwk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_stu_work 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `d_stu_work` DISABLE KEYS */;
REPLACE INTO `d_stu_work` (`stwk_id`, `stu_id`, `work_id`, `stwk_mark`, `stwk_text`) VALUES
	(1, 1, 1, 50, NULL),
	(2, 1, 2, 90, NULL),
	(3, 1, 5, 66, '66666'),
	(4, 2, 1, 44, NULL),
	(5, 2, 2, 33, NULL),
	(6, 2, 5, 22, NULL),
	(7, 3, 1, 90, NULL);
/*!40000 ALTER TABLE `d_stu_work` ENABLE KEYS */;


-- 导出  表 dbteaching.d_subject 结构
CREATE TABLE IF NOT EXISTS `d_subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_id` int(11) NOT NULL,
  `subject_name` varchar(50) NOT NULL DEFAULT '0',
  `subject_intro` varchar(50) DEFAULT NULL,
  `subject_year` varchar(50) NOT NULL,
  `subject_times` int(11) NOT NULL,
  `subject_work` int(11) NOT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `d_subject_d_major_major_id_fk` (`major_id`),
  CONSTRAINT `d_subject_d_major_major_id_fk` FOREIGN KEY (`major_id`) REFERENCES `d_major` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_subject 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `d_subject` DISABLE KEYS */;
REPLACE INTO `d_subject` (`subject_id`, `major_id`, `subject_name`, `subject_intro`, `subject_year`, `subject_times`, `subject_work`) VALUES
	(3, 1, 'C语言开发', '高效运行语言', '2014', 30, 0),
	(4, 1, 'JAVA语言开发', '面向对象的程序设计', '2015', 40, 0),
	(5, 1, 'JavaWeb开发', '基于Structs的应用开发', '2016', 30, 0),
	(6, 2, '模拟电路电学', '对模拟电路进行深度研究', '2015', 35, 0),
	(7, 3, '版权法', '对著作等版权进行维护的法律', '2016', 30, 0),
	(8, 1, '测试1', '测试测试', '2019', 4, 0),
	(9, 1, '测试2', '这里写内容', '2019', 2, 0),
	(12, 1, '测试3', '这里写内容', '2019', 4, 0),
	(13, 1, '测试4', '这里写内容', '2009', 3, 0);
/*!40000 ALTER TABLE `d_subject` ENABLE KEYS */;


-- 导出  表 dbteaching.d_teacher 结构
CREATE TABLE IF NOT EXISTS `d_teacher` (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_name` varchar(50) NOT NULL,
  `tea_sex` varchar(50) DEFAULT NULL,
  `major_id` int(11) NOT NULL,
  `tea_pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_teacher 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `d_teacher` DISABLE KEYS */;
REPLACE INTO `d_teacher` (`tea_id`, `tea_name`, `tea_sex`, `major_id`, `tea_pwd`) VALUES
	(1, 'guanliyuan', '女', 1, '111111'),
	(2, 'jiaoshi1123', NULL, 1, '111');
/*!40000 ALTER TABLE `d_teacher` ENABLE KEYS */;


-- 导出  表 dbteaching.d_tea_value 结构
CREATE TABLE IF NOT EXISTS `d_tea_value` (
  `value_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `tea_id` int(11) NOT NULL,
  `value_1` int(11) NOT NULL,
  `value_2` int(11) NOT NULL,
  `value_3` int(11) NOT NULL,
  `value_content` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_tea_value 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `d_tea_value` DISABLE KEYS */;
REPLACE INTO `d_tea_value` (`value_id`, `stu_id`, `tea_id`, `value_1`, `value_2`, `value_3`, `value_content`) VALUES
	(1, 1, 1, 50, 100, 100, '教的好'),
	(2, 2, 1, 100, 10, 40, NULL),
	(3, 3, 1, 10, 100, 100, '听不太懂'),
	(4, 4, 1, 32, 100, 30, NULL),
	(5, 99, 22, 99, 99, 99, '测试111'),
	(6, 44, 121, 222, 222, 222, '222');
/*!40000 ALTER TABLE `d_tea_value` ENABLE KEYS */;


-- 导出  表 dbteaching.d_work 结构
CREATE TABLE IF NOT EXISTS `d_work` (
  `work_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `work_content` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`work_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  dbteaching.d_work 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `d_work` DISABLE KEYS */;
REPLACE INTO `d_work` (`work_id`, `subject_id`, `lesson_id`, `work_content`) VALUES
	(1, 3, 1, '写一个小程序'),
	(2, 3, 2, '算法计算作业'),
	(3, 4, 5, '测试出存储'),
	(4, 999, 999, '这里写内容'),
	(5, 3, 3, '这里写内容');
/*!40000 ALTER TABLE `d_work` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
