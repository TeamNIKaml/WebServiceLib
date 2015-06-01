<?php 
 class TeamMemberModel
		 {
			var $userId,$name,$designation;
			
			
			function __construct($userId,$name,$designation)
			{
				 $this->userId = $userId;
				 $this->name = $name;
				  $this->designation = $designation;
			}
		}

?>