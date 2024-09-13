console.log('Hello!')


if (typeof document !== 'undefined') {
    // will run in client's browser only
    const date_id = document.getElementById('date_id')

	const options = { year: 'numeric', month: 'long', day: 'numeric' };
	const formattedDate = new Date().toLocaleDateString('en-UK', options);
	
	console.log('formattedDate: '+formattedDate)
	
	date_id.innerText = formattedDate
	
	function taskChecked(checkbox){
		let taskName = checkbox.value
		let taskCheckedStatus = false
		const checkboxValue = document.getElementById(taskName);
		console.log('Inside taskChecked')
		console.log('--------------------------------')
		console.log('taskName: '+taskName)
		if(checkbox.checked){
			taskCheckedStatus = true
			checkboxValue.classList.add('strikethrough');
		}else{
			taskCheckedStatus = false
			checkboxValue.classList.remove('strikethrough');
		}
		fetch(`/checkedTask?param1=${encodeURIComponent(taskName)}&param2=${encodeURIComponent(taskCheckedStatus)}`)
                .then(response => response.text())
                .then(data => {
                    console.log(data); // Process the response here
                })
                .catch(error => console.error('Error:', error));
	}
}



