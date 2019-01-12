<?php

if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$status = $_POST['status'];
		$nominal = $_POST['nominal'];
		$catatan = $_POST['catatan'];
		$tanggal = $_POST['tanggal'];

		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE data_kencleng SET status = '$status', nominal = '$nominal', catatan = '$catatan', tanggal = '$tanggal' WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Kencleng';
		}else{
			echo 'Gagal Update Data Kencleng';
		}

		mysqli_close($con);


?>