Vagrant.configure("2") do |config|

  config.vm.define "tomcat" do |tomcat|
    tomcat.vm.box = "centos/7"
    tomcat.vm.synced_folder ".", "/vagrant", disabled: true
    tomcat.vm.network "forwarded_port", guest: 8080, host: 8000, host_ip: "127.0.0.1"
    tomcat.vm.network "private_network", ip: "192.168.56.102"    

    tomcat.vm.provider "virtualbox" do |v|
      v.name = "centos7_tomcat"
      v.customize [ "modifyvm", :id, "--memory", "1024" ]
    end

    tomcat.vm.provision "ansible" do |ansible|
      ansible.playbook = "tomcat_vm.yml"
    end
  end

  config.vm.define "jenkins" do |jenkins|
    jenkins.vm.box = "centos/7"
    jenkins.vm.synced_folder ".", "/vagrant", disabled: true
    jenkins.vm.network "forwarded_port", guest: 8080, host: 8080, host_ip: "127.0.0.1"
    jenkins.vm.network "private_network", ip: "192.168.56.101"

    jenkins.vm.provider "virtualbox" do |v|
      v.name = "centos7_jenkins"
      v.customize [ "modifyvm", :id, "--memory", "1024" ]
    end

    jenkins.vm.provision "ansible" do |ansible|
      ansible.playbook = "jenkins_vm.yml"
    end
  end

end
