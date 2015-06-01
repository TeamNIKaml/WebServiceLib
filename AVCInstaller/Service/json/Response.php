<?php
	class Response
			{
				public static function loginResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['userKey'] = $data[0];
					$response['designation'] = $data[1];
					$response['pgmId'] = $data[1];						
					$json_response = json_encode($response);
					return $json_response;
				}
				
				
				public static function TaskResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['taskList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				public static function TaskDetailsResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['TaskDetails'] = $data[0];
					$response['AssignedResources'] = $data[1];					
					$json_response = json_encode($response);
					return $json_response;
				}

				public static function AsbestosRegisterResponse($status,$status_message)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$json_response = json_encode($response);
					return $json_response;
				}

				public static function TaskIdentificationResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['TaskIdentificationList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				public static function TaskClassificationResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['TaskClassificationList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				public static function TeamMemberResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['TeamMemberList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				public static function RoomCompleteQuestionResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['RoomCompleteQuestionList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				public static function TestingQuestionResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['TestingQuestionList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				public static function PriorityListResponse($status,$status_message,$data)
				{	header("Content-Type:Application/json");	
					header("HTTP/1.1 $status $status_message");
					$response['status'] = $status;
					$response['status_message'] = $status_message;
					$response['PriorityList'] = $data;							
					$json_response = json_encode($response);
					return $json_response;
				}
				
				
				
				
				
			}

?>