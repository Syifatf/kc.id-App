<?php

    //Import File Koneksi Database
    	require_once('koneksi.php');

    	//Membuat SQL Query
    	$sql = "SELECT * FROM data_kencleng";

    	//Mendapatkan Hasil
    	$r = mysqli_query($con,$sql);

    	//Membuat Array Kosong
    	$result = array();

    	while($row = mysqli_fetch_array($r)){

    		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat
    		array_push($result,array(
    			"id"=>$row['id'],
    			"status"=>$row['status']
    			"nomnal"=>$row['nominal']
    			"catatan"=>$row['catatan']
    			"tanggal"=>$row['tanggal']
    		));
    	}

    	//Menampilkan Array dalam Format JSON
    	echo json_encode(array('result'=>$result));

    	mysqli_close($con);

?>



