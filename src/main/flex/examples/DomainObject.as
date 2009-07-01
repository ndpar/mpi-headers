package examples {

    [Managed]
    [RemoteClass(alias="examples.DomainObject")]
    public class DomainObject {

        private var _id:int;
        private var _name:String;

        public function set id(val:int):void {
            _id = val;
        }

        public function get id():int {
            return _id;
        }

        public function set name(val:String):void {
            _name = val;
        }

        public function get name():String {
            return _name;
        }
    }
}