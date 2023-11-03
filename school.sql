-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2022 at 08:12 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `school`
--

-- --------------------------------------------------------

--
-- Table structure for table `academicstaffattendance`
--

CREATE TABLE `academicstaffattendance` (
  `academic_staff_attendance_id` int(11) NOT NULL,
  `academic_staff_id` int(11) NOT NULL,
  `attendance` int(4) NOT NULL,
  `attendance_date` date NOT NULL,
  `marked_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `academicstaffattendance`
--

INSERT INTO `academicstaffattendance` (`academic_staff_attendance_id`, `academic_staff_id`, `attendance`, `attendance_date`, `marked_by`) VALUES
(1, 1, 1, '2020-01-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `academic_staff`
--

CREATE TABLE `academic_staff` (
  `academic_staff_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `firstName` varchar(124) NOT NULL,
  `lastName` varchar(124) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(1024) NOT NULL,
  `phone_number` varchar(16) NOT NULL,
  `address` varchar(1024) NOT NULL,
  `role` varchar(64) NOT NULL,
  `bio` varchar(1024) NOT NULL,
  `profile_pic` varchar(256) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `academic_staff`
--

INSERT INTO `academic_staff` (`academic_staff_id`, `subject_id`, `firstName`, `lastName`, `date_of_birth`, `email`, `password`, `phone_number`, `address`, `role`, `bio`, `profile_pic`, `created_at`, `updated_at`) VALUES
(1, 1, 'Yashodini', 'Soyza', '2020-12-20', 'yash@test.com', '1234', '0771234567', 'Colombo', 'Guest Teacher', 'I am a lecturer', 'img1668269727326.jpg', '2022-11-04 04:54:45', '2022-11-13 04:46:39');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `firstName` varchar(128) NOT NULL,
  `lastName` varchar(128) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(1024) NOT NULL,
  `phone_number` varchar(16) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `firstName`, `lastName`, `email`, `password`, `phone_number`, `created_at`, `updated_at`) VALUES
(1, 'Yashodini', 'Soyza', 'yash@test.com', '123456', '0771234567', '2022-11-04 04:54:45', '2022-11-04 04:54:45');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `class_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `academic_staff_id` int(11) NOT NULL,
  `class_name` varchar(256) NOT NULL,
  `allocated_classroom` varchar(256) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`class_id`, `subject_id`, `academic_staff_id`, `class_name`, `allocated_classroom`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'Grade 1', 'Classroom 2', '2022-11-04 04:54:45', '2022-11-12 09:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `exam_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `academic_staff_id` int(11) NOT NULL,
  `exam_name` varchar(256) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exams`
--

INSERT INTO `exams` (`exam_id`, `class_id`, `academic_staff_id`, `exam_name`, `created_at`, `updated_at`) VALUES
(2, 1, 1, 'Test', '2022-11-13 05:59:25', '2022-11-13 05:59:25');

-- --------------------------------------------------------

--
-- Table structure for table `nonacademicstaffattendance`
--

CREATE TABLE `nonacademicstaffattendance` (
  `non_academic_staff_attendance_id` int(11) NOT NULL,
  `non_academic_staff_id` int(11) NOT NULL,
  `attendance` int(4) NOT NULL,
  `attendance_date` date NOT NULL,
  `marked_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nonacademicstaffattendance`
--

INSERT INTO `nonacademicstaffattendance` (`non_academic_staff_attendance_id`, `non_academic_staff_id`, `attendance`, `attendance_date`, `marked_by`) VALUES
(1, 1, 1, '2020-01-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `non_academic_staff`
--

CREATE TABLE `non_academic_staff` (
  `non_academic_staff_id` int(11) NOT NULL,
  `firstName` varchar(256) NOT NULL,
  `lastName` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `phone_number` varchar(16) NOT NULL,
  `address` varchar(1024) NOT NULL,
  `date_of_birth` date NOT NULL,
  `role` varchar(64) NOT NULL,
  `bio` varchar(1024) NOT NULL,
  `profile_pic` varchar(1024) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `non_academic_staff`
--

INSERT INTO `non_academic_staff` (`non_academic_staff_id`, `firstName`, `lastName`, `email`, `phone_number`, `address`, `date_of_birth`, `role`, `bio`, `profile_pic`, `created_at`, `updated_at`) VALUES
(1, 'Yashodini', 'Soyzaa', 'yash@test.com', '0771234567', 'Colombo', '2020-12-20', 'Clerk', 'Clerk', 'profile_pic.jpg', '2022-11-04 04:54:45', '2022-11-12 17:31:28');

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

CREATE TABLE `results` (
  `result_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `result` varchar(32) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `studentattendance`
--

CREATE TABLE `studentattendance` (
  `student_attendance_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `attendance` int(4) NOT NULL,
  `attendance_date` date NOT NULL,
  `marked_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentattendance`
--

INSERT INTO `studentattendance` (`student_attendance_id`, `student_id`, `class_id`, `attendance`, `attendance_date`, `marked_by`) VALUES
(1, 1, 1, 1, '2020-01-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `firstName` varchar(256) NOT NULL,
  `lastName` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `phone_number` varchar(16) NOT NULL,
  `password` varchar(1024) NOT NULL,
  `address` varchar(512) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` varchar(16) NOT NULL,
  `bio` varchar(1024) NOT NULL,
  `profile_pic` varchar(1024) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `class_id`, `firstName`, `lastName`, `email`, `phone_number`, `password`, `address`, `date_of_birth`, `gender`, `bio`, `profile_pic`, `created_at`, `updated_at`) VALUES
(1, 1, 'Test', 'pp', 'test@test.com', '076456645', '123456', 'Galle', '2021-11-20', 'Female', 'utydfytytytdyd', 'img1668145653517.jpg', '2022-11-04 04:54:45', '2022-11-11 05:47:33'),
(4, 1, 'Kavindu', 'Lakshan', 'test@test.com', '0762783786', 'test', 'test', '2017-11-20', 'Female', 'test', 'img1668322211334.jpg', '2022-11-12 17:20:15', '2022-11-13 06:50:11');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(128) NOT NULL,
  `description` varchar(512) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`subject_id`, `subject_name`, `description`, `created_at`, `updated_at`) VALUES
(1, 'Mathematics', 'Mathematics is the study of quantity, structure, space, and change.', '2022-11-04 04:54:45', '2022-11-12 09:35:15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academicstaffattendance`
--
ALTER TABLE `academicstaffattendance`
  ADD PRIMARY KEY (`academic_staff_attendance_id`),
  ADD KEY `academic_staff_id` (`academic_staff_id`),
  ADD KEY `marked_by` (`marked_by`);

--
-- Indexes for table `academic_staff`
--
ALTER TABLE `academic_staff`
  ADD PRIMARY KEY (`academic_staff_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `academic_staff_id` (`academic_staff_id`);

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`exam_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `academic_staff_id` (`academic_staff_id`);

--
-- Indexes for table `nonacademicstaffattendance`
--
ALTER TABLE `nonacademicstaffattendance`
  ADD PRIMARY KEY (`non_academic_staff_attendance_id`),
  ADD KEY `non_academic_staff_id` (`non_academic_staff_id`),
  ADD KEY `marked_by` (`marked_by`);

--
-- Indexes for table `non_academic_staff`
--
ALTER TABLE `non_academic_staff`
  ADD PRIMARY KEY (`non_academic_staff_id`);

--
-- Indexes for table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`result_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `exam_id` (`exam_id`);

--
-- Indexes for table `studentattendance`
--
ALTER TABLE `studentattendance`
  ADD PRIMARY KEY (`student_attendance_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `marked_by` (`marked_by`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `academicstaffattendance`
--
ALTER TABLE `academicstaffattendance`
  MODIFY `academic_staff_attendance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `academic_staff`
--
ALTER TABLE `academic_staff`
  MODIFY `academic_staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `exams`
--
ALTER TABLE `exams`
  MODIFY `exam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nonacademicstaffattendance`
--
ALTER TABLE `nonacademicstaffattendance`
  MODIFY `non_academic_staff_attendance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `non_academic_staff`
--
ALTER TABLE `non_academic_staff`
  MODIFY `non_academic_staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `results`
--
ALTER TABLE `results`
  MODIFY `result_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `studentattendance`
--
ALTER TABLE `studentattendance`
  MODIFY `student_attendance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `academicstaffattendance`
--
ALTER TABLE `academicstaffattendance`
  ADD CONSTRAINT `academicstaffattendance_ibfk_1` FOREIGN KEY (`academic_staff_id`) REFERENCES `academic_staff` (`academic_staff_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `academicstaffattendance_ibfk_2` FOREIGN KEY (`marked_by`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE;

--
-- Constraints for table `academic_staff`
--
ALTER TABLE `academic_staff`
  ADD CONSTRAINT `academic_staff_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE CASCADE;

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`academic_staff_id`) REFERENCES `academic_staff` (`academic_staff_id`) ON DELETE CASCADE;

--
-- Constraints for table `exams`
--
ALTER TABLE `exams`
  ADD CONSTRAINT `exams_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `exams_ibfk_2` FOREIGN KEY (`academic_staff_id`) REFERENCES `academic_staff` (`academic_staff_id`) ON DELETE CASCADE;

--
-- Constraints for table `nonacademicstaffattendance`
--
ALTER TABLE `nonacademicstaffattendance`
  ADD CONSTRAINT `nonacademicstaffattendance_ibfk_1` FOREIGN KEY (`non_academic_staff_id`) REFERENCES `non_academic_staff` (`non_academic_staff_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `nonacademicstaffattendance_ibfk_2` FOREIGN KEY (`marked_by`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE;

--
-- Constraints for table `results`
--
ALTER TABLE `results`
  ADD CONSTRAINT `results_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `results_ibfk_2` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`) ON DELETE CASCADE;

--
-- Constraints for table `studentattendance`
--
ALTER TABLE `studentattendance`
  ADD CONSTRAINT `studentattendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `studentattendance_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `studentattendance_ibfk_3` FOREIGN KEY (`marked_by`) REFERENCES `academic_staff` (`academic_staff_id`) ON DELETE CASCADE;

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
